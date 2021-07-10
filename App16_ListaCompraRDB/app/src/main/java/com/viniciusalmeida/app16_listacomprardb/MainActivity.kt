package com.viniciusalmeida.app16_listacomprardb

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity(), ComprasAdapterListener {

    lateinit var comprasAdapter: ComprasAdapter
    lateinit var edtCompras: EditText
    lateinit var edtQuantia: EditText
    lateinit var btnIncluir: ImageButton
    lateinit var preferenciasCompras: SharedPreferences
    lateinit var rv: RecyclerView

    var db: AppDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // #Preferencias
        // Criando o arquivo de preferências
        preferenciasCompras = getSharedPreferences("comprasPreferences", Context.MODE_PRIVATE)

        rv = findViewById<RecyclerView>(R.id.rvCompras)

        btnIncluir = findViewById(R.id.btnIncluir)
        edtCompras = findViewById(R.id.edtCompras)
        edtQuantia = findViewById(R.id.edtQuantia)

        btnIncluir.setOnClickListener() {
            if (edtCompras.text.toString().isNotEmpty() && edtQuantia.text.toString().isNotEmpty()) {
                adicionarProduto(edtCompras.text.toString(), edtQuantia.text.toString())
                edtCompras.text.clear()
                edtQuantia.text.clear()

                // Apagar a preferência gravada anteriormente
                val editor = preferenciasCompras.edit()
                editor.remove("PRODUTO")
                editor.commit()
                editor.remove("QTD")
                editor.commit()

            } else {
                edtCompras.error = "Insira um produto válido!"
                edtQuantia.error = "Insira uma quantia válida!"
            }
            /*if (edtQuantia.text.toString().isNotEmpty()) {
                adicionarQuantia(edtQuantia.text.toString())
                edtQuantia.text.clear()
                val editor = preferenciasCompras.edit()
                editor.remove("QTD")
                editor.commit()

            } else {
                edtQuantia.error = "Insira uma quantia válida!"
            }*/
        }
    }

    fun adicionarProduto(nomeProduto: String, nomeQuantia: String) {
        // Coroutine para Entrada/Saída de Dados
        CoroutineScope(Dispatchers.IO).launch {
            // Cria ou recupera o BD da aplicação
            db = DatabaseBuilder.getAppDatabase(this@MainActivity)

            // A partir do DAO executa uma ação escolhida (INSERT)
            db?.comprasDao()?.addCompras(Compras(produto = nomeProduto, qtd = nomeQuantia))

            // Recupera ações/métodos de acesso a dados da entidade (tabela)
            val comprasDAO = db?.comprasDao()

            // A partir do DAO executa uma ação escolhida (SELECT)
            val resposta = comprasDAO?.getCompras()

            // Coroutine para UI
            withContext(Dispatchers.Main) {
                resposta?.let {
                    comprasAdapter.refreshListCompras(resposta)
                }
            }
        }
    }
    /*fun adicionarQuantia(nomeQuantia: String) {
        // Coroutine para Entrada/Saída de Dados
        CoroutineScope(Dispatchers.IO).launch {
            // Cria ou recupera o BD da aplicação
            db = DatabaseBuilder.getAppDatabase(this@MainActivity)

            // A partir do DAO executa uma ação escolhida (INSERT)
            db?.comprasDao()?.addCompras(Compras(qtd = nomeQuantia))

            // Recupera ações/métodos de acesso a dados da entidade (tabela)
            val comprasDAO = db?.comprasDao()

            // A partir do DAO executa uma ação escolhida (SELECT)
            val resposta = comprasDAO?.getCompras()

            // Coroutine para UI
            withContext(Dispatchers.Main) {
                resposta?.let {
                    comprasAdapter.refreshListCompras(resposta)
                }
            }
        }
    } */

    fun recuperarLista(){
        // Coroutine para Entrada/Saída de Dados
        CoroutineScope(Dispatchers.IO).launch {
            // Cria ou recupera o BD da aplicação
            db = DatabaseBuilder.getAppDatabase(this@MainActivity)

            // Recupera ações/métodos de acesso a dados da entidade (tabela)
            val comprasDAO = db?.comprasDao()

            // A partir do DAO executa uma ação escolhida (SELECT)
            val resposta = comprasDAO?.getCompras()

            // Coroutine para UI
            withContext(Dispatchers.Main){
                resposta?.let{
                    comprasAdapter = ComprasAdapter(it, this@MainActivity)

                    // Vincula o Adapter na Recycler View
                    rv.adapter = comprasAdapter

                    // Exibe os itens em uma coluna única no padrão vertical
                    rv.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }
        }
    }

    // #Preferencias
    override fun onPause() {
        super.onPause()

        if (edtCompras.text.toString().isNotEmpty()){

            // Cria e edição na preferência
            val editor = preferenciasCompras.edit()

            // Escreve um uma preferência
            editor.putString("PRODUTO", edtCompras.text.toString())

            // Salva a preferência
            editor.commit()
        }
        if (edtQuantia.text.toString().isNotEmpty()){
            val editor = preferenciasCompras.edit()
            editor.putString("QTD", edtQuantia.text.toString())
            editor.commit()
        }
    }

    // #Preferencias
    override fun onResume() {
        super.onResume()

        // Recupera (lê) uma preferência e utiliza ela populando um Edit Text
        edtCompras.setText(preferenciasCompras.getString("PRODUTO", null))
        edtQuantia.setText(preferenciasCompras.getString("QTD", null))
    }

    override fun onStart() {
        super.onStart()

        recuperarLista()
    }

    override fun excluirCompra(compras: Compras) {
        // Coroutine para Entrada/Saída de Dados
        CoroutineScope(Dispatchers.IO).launch {
            // Cria ou recupera o BD da aplicação
            db = DatabaseBuilder.getAppDatabase(this@MainActivity)

            // A partir do DAO executa uma ação escolhida (DELETE)
            db?.comprasDao()?.deleteCompra(compras)

            // Recupera ações/métodos de acesso a dados da entidade (tabela)
            val comprasDAO = db?.comprasDao()

            // A partir do DAO executa uma ação escolhida (SELECT)
            val resposta = comprasDAO?.getCompras()

            // Coroutine para UI
            withContext(Dispatchers.Main) {
                resposta?.let {
                    comprasAdapter.refreshListCompras(resposta)

                    Toast.makeText(this@MainActivity, "Produto excluído", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
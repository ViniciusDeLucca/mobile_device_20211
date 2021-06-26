@file:Suppress("DEPRECATION")

package com.viniciusalmeida.app5_tirarfoto

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {

    private lateinit var foto: ImageView
    private lateinit var nome : EditText
    private lateinit var botaoTirarFoto: Button
    private lateinit var botaoSalvar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        foto = findViewById(R.id.imageView)
        nome = findViewById(R.id.inputNome)
        botaoTirarFoto = findViewById(R.id.btnFoto)
        botaoSalvar  = findViewById(R.id.btnSalvar)

        botaoSalvar.setOnClickListener {
        //Uma intent explicita
            val intentSalvar = Intent(this@MainActivity, CadastradoAct::class.java)

            val usuario = Usuario(nome = nome.text.toString())
            intentSalvar.putExtra("USUARIO", usuario)

            startActivity(intentSalvar)
        }
        botaoTirarFoto.setOnClickListener {
            abrirCamera()
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    fun abrirCamera(){
    //Uma intent implicita
        val intentCamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        if (intentCamera.resolveActivity(packageManager) != null){
            startActivityForResult(intentCamera, 12345)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 12345 && resultCode == RESULT_OK) {
            val fotoTirada = data?.extras?.get("data") as Bitmap
            foto.setImageBitmap(fotoTirada)
        }
    }
    @Suppress("MoveLambdaOutsideParentheses")
    override fun onBackPressed() {
        val dialog = AlertDialog.Builder(this@MainActivity)
        dialog.setTitle("Vai embora já? Fica mais pô")
        dialog.setPositiveButton("Valeu falou", { _, _ ->  super.onBackPressed()})
        dialog.create().show()
    }
}
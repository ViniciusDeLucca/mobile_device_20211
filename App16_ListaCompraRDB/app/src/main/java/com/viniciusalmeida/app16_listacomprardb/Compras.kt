package com.viniciusalmeida.app16_listacomprardb

import androidx.room.*

@Entity(tableName = "TB_COMPRAS")
data class Compras(
    @PrimaryKey(autoGenerate = true)
    var id: Int=0,
    val produto: String,
    var qtd: String,
)

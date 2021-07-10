package com.viniciusalmeida.app15_listatarefardb

import androidx.room.*

@Entity(tableName = "TB_TAREFA")
data class Tarefa(
    @PrimaryKey(autoGenerate = true)
    var id: Int=0,
    @ColumnInfo(name="Nome")
    val nome: String,
)

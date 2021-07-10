package com.viniciusalmeida.app16_listacomprardb

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Compras::class), version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun comprasDao():ComprasDAO

    // Implementar aqui todos os DAOs que o App tiver daqui pra baixo...
}

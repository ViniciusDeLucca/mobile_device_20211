package com.viniciusalmeida.app7_listausuariofoto

import android.graphics.drawable.Drawable

data class Usuario(
    var foto : Drawable? = null,
    var nome: String,
    var email: String,
    var graduacao: Graduacao,
    var setor: Setor
)


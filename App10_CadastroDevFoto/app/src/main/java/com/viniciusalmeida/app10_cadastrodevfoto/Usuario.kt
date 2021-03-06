package com.viniciusalmeida.app10_cadastrodevfoto

import android.graphics.Bitmap

data class Usuario(
    var foto: Bitmap?=null,
    var nome: String,
    var email: String,
    var stack: Stack,
    var senioridade: Senioridade,
    var empregado: Boolean
)

package com.viniciusalmeida.app8_listapetfoto

import android.graphics.drawable.Drawable

data class Pet(
    var foto : Drawable? = null,
    var nome : String,
    var raca : Raca
)
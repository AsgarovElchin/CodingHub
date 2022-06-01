package com.elchinasgarov.codinghub.utils

import androidx.annotation.ColorRes
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

fun CardView.setBackgroundColorByRes(@ColorRes colorResId:Int){
    setBackgroundColor(ContextCompat.getColor(context,colorResId))

}
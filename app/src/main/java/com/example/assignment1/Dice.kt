package com.example.assignment1

import android.widget.ImageView
import androidx.core.content.ContextCompat
import java.util.*

class Dice (val imageView: ImageView) {
    var value: Int? = null
    val random = Random()

    fun getImageResource() :ImageView{
        return imageView
    }

    fun roll(){
        value = random.nextInt(6)
        val drawableId = when (value) {
            1 -> R.drawable.die_face_1
            2 -> R.drawable.die_face_2
            3 -> R.drawable.die_face_3
            4 -> R.drawable.die_face_4
            5 -> R.drawable.die_face_5
            else -> R.drawable.die_face_6
        }
        val drawable = ContextCompat.getDrawable(imageView.context, drawableId)
        imageView.setImageDrawable(drawable)
    }

    fun score(): Int{
        return value ?: 0
    }
}
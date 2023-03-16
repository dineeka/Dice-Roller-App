package com.example.assignment1

import android.graphics.Color
import android.widget.ImageView
import androidx.core.content.ContextCompat
import java.util.*

class Dice (val imageView: ImageView) {
    var value: Int? = null
    var selected = false
    val random = Random()

    fun getImageResource() :ImageView{
        return imageView
    }

    fun setClicked(value: Boolean){
        selected = value
    }

    fun roll(){
        value = random.nextInt(6) + 1
        val drawableId = when (value) {
            1 -> R.drawable.die_face_1
            2 -> R.drawable.die_face_2
            3 -> R.drawable.die_face_3
            4 -> R.drawable.die_face_4
            5 -> R.drawable.die_face_5
            6 -> R.drawable.die_face_6
            else -> R.drawable.die_face_6
        }
        val drawable = ContextCompat.getDrawable(imageView.context, drawableId)
        imageView.setImageDrawable(drawable)
    }

    fun score(): Int{
        return value ?: 0
    }

    fun setAppearance(){
        imageView.setPadding(5, 5, 5, 5)
        imageView.setBackgroundColor(Color.GREEN)
    }

    fun resetAppearance(){
        imageView.setPadding(0, 0, 0, 0)
        imageView.setBackgroundColor(Color.WHITE)
    }
}
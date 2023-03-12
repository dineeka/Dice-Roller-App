package com.example.assignment1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.PopupMenu
import android.widget.PopupWindow
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //https://www.geeksforgeeks.org/popup-menu-in-android-with-example/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newGameBtn: Button = findViewById(R.id.newBtn)
        newGameBtn.setOnClickListener {
            val newGameIntent = Intent(this,NewGameActivity::class.java)
            startActivity(newGameIntent)
        }


        val aboutBtn: Button = findViewById(R.id.aboutBtn)
        aboutBtn.setOnClickListener{showAbout()}

    }



    @SuppressLint("ClickableViewAccessibility")
    private fun showAbout(){

        val inflater = LayoutInflater.from(this)
        val view = inflater.inflate(R.layout.popup_window, null) // put my own layout here

        val popupWindow = PopupWindow(
            view,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            true
        )

// show the popup window
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)

// dismiss the popup window when touched outside of it
        view.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_OUTSIDE) {
                popupWindow.dismiss()
                true
            } else {
                false
            }
        }
    }


}
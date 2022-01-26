package com.prateek.edvora

import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    var path = Path()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

    val redBtn = findViewById<ImageButton>(R.id.red)
    val greenBtn = findViewById<ImageButton>(R.id.green)
    val blueBtn = findViewById<ImageButton>(R.id.blue)
    val purpleBtn = findViewById<ImageButton>(R.id.purple)
    val colorBtn = findViewById<ImageButton>(R.id.color)
    val colors= findViewById<LinearLayout>(R.id.colors)


        redBtn.setOnClickListener{
            colors.visibility=View.INVISIBLE

        }
        greenBtn.setOnClickListener{

        }
        blueBtn.setOnClickListener{

        }
        purpleBtn.setOnClickListener{

        }
        colorBtn.setOnClickListener{
           colors.visibility=View.VISIBLE

        }

    }


}
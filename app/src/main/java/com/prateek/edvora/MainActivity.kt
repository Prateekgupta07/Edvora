package com.prateek.edvora

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.core.view.isVisible
import com.prateek.edvora.DrawingView.Companion.current

class MainActivity : AppCompatActivity() {
    companion object {
        var path = Path()
        var paint1 =Paint()
        var type1= "pencil"



    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()


        val redBtn = findViewById<ImageButton>(R.id.red)
        val brush = findViewById<ImageButton>(R.id.brush)
        val greenBtn = findViewById<ImageButton>(R.id.green)
        val blueBtn = findViewById<ImageButton>(R.id.blue)
        val purpleBtn = findViewById<ImageButton>(R.id.purple)
        val colorBtn = findViewById<ImageButton>(R.id.color)
        val colors = findViewById<LinearLayout>(R.id.colors)
        val circle = findViewById<ImageButton>(R.id.circle)



        redBtn.setOnClickListener {
            paint1.setColor(Color.RED)
            currentColor(paint1.color)
            colors.visibility = View.GONE


        }
        greenBtn.setOnClickListener {
            paint1.setColor(Color.GREEN)
            currentColor(paint1.color)
            colors.visibility = View.GONE

        }
        blueBtn.setOnClickListener {
            paint1.setColor(Color.BLUE)
            currentColor(paint1.color)
            colors.visibility = View.GONE

        }
        purpleBtn.setOnClickListener {
            paint1.setColor(Color.CYAN)
            currentColor(paint1.color)

            colors.visibility = View.GONE

        }
        brush.setOnClickListener {
        type1 = "pencil"
    }
        circle.setOnClickListener{
             type1 ="circle"

        }

        colorBtn.setOnClickListener{
           colors.visibility=View.VISIBLE
        }
    }
    private fun currentColor(color: Int){
        current = color
        path= Path()
    }
}

object Paint2 {

}

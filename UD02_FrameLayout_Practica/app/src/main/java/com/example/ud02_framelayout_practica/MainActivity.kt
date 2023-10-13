package com.example.ud02_framelayout_practica

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text =findViewById<TextView>(R.id.text)

        val ourenseImg= findViewById<ImageView>(R.id.ourense)
        ourenseImg.setOnClickListener {
            text.setText("Algo sobre Ourense")
        }
        val santiagoImg =findViewById<ImageView>(R.id.santiago)
        santiagoImg.setOnClickListener {
            text.setText("Algo sobre Santiago")
        }
    }
}
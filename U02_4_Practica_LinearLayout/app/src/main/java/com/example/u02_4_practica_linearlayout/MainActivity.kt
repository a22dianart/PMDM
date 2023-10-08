package com.example.u02_4_practica_linearlayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val llamarBtn = findViewById<Button>(R.id.llamarBtn)
        val llamando = findViewById<TextView>(R.id.llamando)
        val mensaxe = "LLamando a "
        llamarBtn.setOnClickListener {
            llamando.text = mensaxe

        }
    }

}
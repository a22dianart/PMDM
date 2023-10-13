package com.example.ud02_constraintlayout_practica

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user =findViewById<TextView>(R.id.user)
        val password= findViewById<TextView>(R.id.password)
        val userTxt = user.text
        val passwordTxt= password.text
        val text = findViewById<TextView>(R.id.text)
        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            text.setVisibility(TextView.VISIBLE)
            text.setText("Usuario: $userTxt Contraseña: $passwordTxt")


        }
    }
}
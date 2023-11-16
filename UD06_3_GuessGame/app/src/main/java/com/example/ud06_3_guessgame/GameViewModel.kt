package com.example.ud06_3_guessgame

import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel(){
    var words = listOf("Casa", "Gato", "Chico")
    var secretWord = words.random().uppercase()


}
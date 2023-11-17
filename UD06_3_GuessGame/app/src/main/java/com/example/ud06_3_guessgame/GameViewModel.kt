package com.example.ud06_3_guessgame

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel(){
    var words = listOf("Casa", "Gato", "Chico")
    var secretWord = words.random().uppercase()
    //Palabra secreta que vou mostrar
    var secretWordDisplay = MutableLiveData<String>()
    //Número de vidas
    var lives =MutableLiveData<Int>(5)
    //Intentos do usuario. Caracteres
    var  guesses = mutableListOf<Char>()

    init{
        secretWordDisplay.value= generateWordDisplay()
    }
    fun generateWordDisplay()=
        secretWord.map {
            if(it in guesses) it

                else "_"
        }.joinToString("")

    fun game(guess : Char ){
        //Engado o caractere á lista de intentos
        guesses.add(guess.uppercaseChar())
        //Actualizo a palabra que vou mostrar
        secretWordDisplay.value =generateWordDisplay()
        //Actualizando as vidas
        if(secretWord.contains(guess.uppercaseChar())) lives.value?.minus(1)

    }
    fun win() = secretWord.equals(secretWordDisplay)
    fun lost() = lives.value?:0 <=0

    fun resultMessage() =
        if (win()) "Ganaste la palabra secreta era $secretWord"
        else "Opps, perdiste la palabra secreta era $secretWord"

    fun restart(){
        guesses.clear()
        lives.value=5
        secretWord=words.random().uppercase()
        secretWordDisplay.value=generateWordDisplay()

    }





}
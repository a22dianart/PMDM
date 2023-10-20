package com.example.ud03_1_secretapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class EncryptFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val message =EncryptFragmentArgs.fromBundle(requireArguments()).message
        val view= inflater.inflate(R.layout.fragment_encrypt, container, false)
        view.findViewById<TextView>(R.id.encrypt_textValue).text=message
        return view
    }
    fun cifrado(message: String)= message.map{//metodo para que devolva o caracter +3 (solo letras maiusculas ou minusculas, senon o mesmo) Devolve en maiusuclas
        var num = it.uppercase().hashCode()


    }

}
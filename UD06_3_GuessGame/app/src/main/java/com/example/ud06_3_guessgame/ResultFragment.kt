package com.example.ud06_3_guessgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.ud06_3_guessgame.databinding.FragmentGameBinding
import com.example.ud06_3_guessgame.databinding.FragmentResultBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        val view = binding.root
        val gameModel : GameViewModel by viewModels(
            ownerProducer = {this.requireActivity()}
        )
        binding.txtResult.text = gameModel.resultMessage()

        binding.buttonNewGame.setOnClickListener{
            gameModel.restart()
            view.findNavController().navigate(R.id.action_resultFragment_to_gameFragment)
            //Toast.makeText(activity,gameModel.secretWord, Toast.LENGTH_SHORT).show()
        }
        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null

    }
}
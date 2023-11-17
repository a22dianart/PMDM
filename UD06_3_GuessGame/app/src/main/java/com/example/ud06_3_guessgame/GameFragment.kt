package com.example.ud06_3_guessgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.ud06_3_guessgame.databinding.FragmentGameBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    val gameModel: GameViewModel by viewModels(
        ownerProducer = { this.requireActivity() }

    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.buttonNext.setOnClickListener {
            if (binding.txtGuess.text.length > 0) {
                //gameModel.secretWord = "Palabra de prueba"
                gameModel.game(binding.txtGuess.text.toString()[0])
                updateScreen()
                if (gameModel.win() || gameModel.lost())
                    view.findNavController().navigate(R.id.action_gameFragment_to_resultFragment)

                //view.findNavController().navigate(R.id.action_gameFragment_to_resultFragment)
            } else {
                Toast.makeText(context, "Introduce una letra", Toast.LENGTH_SHORT).show()

            }

        }
        gameModel.lives.observe(
            viewLifecycleOwner,
            Observer {
                it -> binding.txtLives.text = "Te quedan ${it} vidas"
            }
        )
        gameModel.secretWordDisplay.observe(
            viewLifecycleOwner,
            Observer {
                it -> binding.txtWord.text = gameModel.secretWordDisplay.value
            }
        )

        return view
    }

    fun updateScreen() { //agora non faría nada xa qque temos o live
        binding.txtWord.text = gameModel.secretWordDisplay.value
        binding.txtLives.text = "Te quedan ${gameModel.lives} vidas"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null

    }
}
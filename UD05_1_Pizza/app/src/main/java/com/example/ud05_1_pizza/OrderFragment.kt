package com.example.ud05_1_pizza

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class OrderFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_order, container, false)
        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)


        val fabNext=view.findViewById<FloatingActionButton>(R.id.fab)
        fabNext.setOnClickListener{
            val pizzaGroup=view.findViewById<RadioGroup>(R.id.group_pizza_type)
            val pizzaType = pizzaGroup.checkedRadioButtonId
            var msg = ""
            if (pizzaType==-1){
                msg = "Debes seleccionar un tipo de pizza"

            }else{
                msg = "Seleccionaches unha pizza de tipo "
                msg += when(pizzaType){
                    R.id.radio_margarita -> "Margarita"
                    R.id.radio_calzone -> "Calzone"
                    else -> "No existe"
                }
                //Extras
                var parmesano =view.findViewById<Chip>(R.id.chip_parmesano)
                var mozzarella =view.findViewById<Chip>(R.id.chip_mozzarella)
                if (parmesano.isChecked){
                    msg+= " con parmesano"
                }
                if (mozzarella.isChecked){
                    msg+= " con mozzarella"
                }


            }
            val toast = Toast.makeText(activity, msg, Toast.LENGTH_SHORT)
            val snackbar = Snackbar.make(fabNext,msg,Snackbar.LENGTH_SHORT)
            snackbar.setAction("Undo"){
                //accion a realizar cando se pulsa Undo
                pizzaGroup.clearCheck()
            }
            snackbar.show()

        }



        return view
    }
}
package com.grud.clone_nubank.nubank_clonekt.Primario

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.grud.clone_nubank.nubank_clonekt.R
import com.grud.clone_nubank.nubank_clonekt.databinding.FragmentTelaA1Binding


class TelaA_1Fragment : Fragment() {

    //implementação do view Binding Fragment
    private var _binding:  FragmentTelaA1Binding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTelaA1Binding.inflate(inflater, container, false)


        Clickcomecar()
        return binding.root
    }

    private fun Clickcomecar(){//binding + id + evento + navegação
        binding.btnComecar.setOnClickListener{
            findNavController().navigate(R.id.action_telaA_1Fragment_to_tela_CpfFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
package com.grud.clone_nubank.nubank_clonekt.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.grud.clone_nubank.nubank_clonekt.R
import com.grud.clone_nubank.nubank_clonekt.RegistroViewModel
import com.grud.clone_nubank.nubank_clonekt.databinding.FragmentTelaEmailBinding
import com.grud.clone_nubank.nubank_clonekt.databinding.FragmentTelaTelefoneBinding

class Tela_telefoneFragment : Fragment() {

    //implementação do view Binding Fragment
    private var _binding: FragmentTelaTelefoneBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTelaTelefoneBinding.inflate(inflater, container, false)






        clickTelefone()
        return binding.root

    }
    private fun clickTelefone(){
        binding.clickTelefone.setOnClickListener{

            val viewModel = ViewModelProvider(requireActivity()).get(RegistroViewModel::class.java)
            val telefone = binding.edtTelefone.text.toString().trim() // Recupera o nome do EditText


            // Armazena o nome no ViewModel
            viewModel.telefone = telefone

            findNavController().navigate(R.id.action_tela_telefoneFragment_to_tela_nomeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}


package com.grud.clone_nubank.nubank_clonekt.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.grud.clone_nubank.nubank_clonekt.R
import com.grud.clone_nubank.nubank_clonekt.RegistroViewModel
import com.grud.clone_nubank.nubank_clonekt.databinding.FragmentTelaEmailBinding
import com.grud.clone_nubank.nubank_clonekt.databinding.FragmentTelaNomeBinding
import com.grud.clone_nubank.nubank_clonekt.databinding.FragmentTelaTelefoneBinding

class Tela_nomeFragment : Fragment() {

    //implementação do view Binding Fragment
    private var _binding: FragmentTelaNomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTelaNomeBinding.inflate(inflater, container, false)

        // Initialize Firebase Auth
        auth = Firebase.auth


        clickNome()
        return binding.root

    }
    private fun clickNome(){
        binding.clickNome.setOnClickListener{

            val viewModel = ViewModelProvider(requireActivity()).get(RegistroViewModel::class.java)
            val nome = binding.edtNome.text.toString().trim() // Recupera o nome do EditText

            // Armazena o nome no ViewModel
            viewModel.nome = nome

            findNavController().navigate(R.id.action_tela_nomeFragment_to_tela_CriarSenhaFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}


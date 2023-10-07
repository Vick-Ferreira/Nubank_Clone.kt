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

class Tela_emailFragment : Fragment() {

    //implementação do view Binding Fragment
    private var _binding:  FragmentTelaEmailBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTelaEmailBinding.inflate(inflater, container, false)

        // Initialize Firebase Auth
        auth = Firebase.auth

        clickEmail()
        return binding.root

    }

    private fun clickEmail(){
        binding.clickEmail.setOnClickListener{
            val viewModel = ViewModelProvider(requireActivity()).get(RegistroViewModel::class.java)
            val email = binding.edtEmail.text.toString().trim() // Recupera o email do EditText

             // Armazena o nome no ViewModel
            viewModel.email = email
            // Navega para o próximo fragmento
            findNavController().navigate(R.id.action_tela_emailFragment_to_tela_telefoneFragment)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
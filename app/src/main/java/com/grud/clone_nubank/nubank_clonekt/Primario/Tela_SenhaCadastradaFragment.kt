package com.grud.clone_nubank.nubank_clonekt.Primario

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.grud.clone_nubank.nubank_clonekt.R
import com.grud.clone_nubank.nubank_clonekt.databinding.FragmentTelaCpfBinding
import com.grud.clone_nubank.nubank_clonekt.databinding.FragmentTelaSenhaCadastradaBinding

class Tela_SenhaCadastradaFragment : Fragment() {

    //implementação do view Binding Fragment
    private var _binding:  FragmentTelaSenhaCadastradaBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTelaSenhaCadastradaBinding.inflate(inflater, container, false)



        // Initialize Firebase Auth
        auth = Firebase.auth

        clickEntrarConta()
        return binding.root

    }
    private fun  clickEntrarConta() {
        binding.clickSenhaCadastrada.setOnClickListener {
            findNavController().navigate(R.id.action_tela_SenhaCadastradaFragment_to_tela_BFragment)

        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
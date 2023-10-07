package com.grud.clone_nubank.nubank_clonekt.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.grud.clone_nubank.nubank_clonekt.R
import com.grud.clone_nubank.nubank_clonekt.RegistroViewModel
import com.grud.clone_nubank.nubank_clonekt.databinding.FragmentTelaCpfBinding
import com.grud.clone_nubank.nubank_clonekt.databinding.FragmentTelaCriarSenhaBinding


class Tela_CriarSenhaFragment : Fragment() {
    private var _binding: FragmentTelaCriarSenhaBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth
    private val ViewModel by lazy {
        ViewModelProvider(requireActivity()).get(RegistroViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTelaCriarSenhaBinding.inflate(inflater, container, false)

        // Initialize Firebase Auth
        auth = Firebase.auth

        clickSenhaCriada()
        return binding.root

    }

    private fun clickSenhaCriada() {
        binding.clickcriarSenha.setOnClickListener {

            // Recupera os dados armazenados no ViewModel
            val senha = binding.edtSenhaCriada.text.toString().trim() // Recupera a senha do EditText
            // Armazena a senha no ViewModel
            ViewModel.senha = senha


            // Crie um objeto de dados do usuário para enviar ao Firebase
            val usuario = ViewModel

            // Configura uma referência ao nó de dados do usuário no Firebase Realtime Database
            val databaseReference = FirebaseDatabase.getInstance().getReference("dadosUsuarios")


             // Envie os dados do usuário para o Firebase
            // Use o CPF como chave para o nó de dados do usuário
            databaseReference.child(usuario.cpf).setValue(usuario)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // O cadastro foi realizado com sucesso
                        findNavController().navigate(R.id.action_tela_CriarSenhaFragment_to_tela_BFragment)
                    } else {
                        // Ocorreu um erro durante o cadastro, você pode tratar aqui
                        Toast.makeText(
                            requireContext(),
                            "Erro ao cadastrar usuário",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}





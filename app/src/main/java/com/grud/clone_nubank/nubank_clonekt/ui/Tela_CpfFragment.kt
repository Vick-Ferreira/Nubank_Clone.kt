package com.grud.clone_nubank.nubank_clonekt.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import com.grud.clone_nubank.nubank_clonekt.R
import com.grud.clone_nubank.nubank_clonekt.RegistroViewModel
import com.grud.clone_nubank.nubank_clonekt.databinding.FragmentTelaCpfBinding

class Tela_CpfFragment : Fragment() {

    //implementação do view Binding Fragment
    private var _binding: FragmentTelaCpfBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTelaCpfBinding.inflate(inflater, container, false)


        // Initialize Firebase Auth
        auth = Firebase.auth

        clickCPF()
        return binding.root

    }

    //ao clicar no btn com id clickCPF vai chamar validar dados
    private fun clickCPF() {
        binding.clickCpf.setOnClickListener {
            validarDados()
        }
    }

    //função criada para validar dados de login
    private fun validarDados() {

        //recuperar CPF que USER inseriu
        val cpf = binding.edtCpf.text.toString().trim()

        //se não estiver vazio é que o USER já digitou algo
        if (cpf.isNotEmpty()) {
            verificarCpf(cpf)
        } else {
            Toast.makeText(requireContext(), "Informe seu CPF", Toast.LENGTH_SHORT).show()
        }
    }

    // Função de verificação de usuário cadastrado
    private fun verificarCpf(cpf: String) {
        val databaseReference = FirebaseDatabase.getInstance().getReference("dadosUsuarios")
        databaseReference.child(cpf).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    // O CPF já está cadastrado
                    // Navegue para a próxima tela
                    findNavController().navigate(R.id.action_tela_CpfFragment_to_tela_SenhaCadastradaFragment)
                } else {
                    // O CPF não foi encontrado
                    val viewModel =
                        ViewModelProvider(requireActivity()).get(RegistroViewModel::class.java)
                    viewModel.cpf = cpf // Armazena o CPF no ViewModel
                    findNavController().navigate(R.id.action_tela_CpfFragment_to_tela_emailFragment)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Tratar erros, se necessário
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
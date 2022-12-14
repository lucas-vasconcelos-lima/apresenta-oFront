package com.example.doesaude

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.doesaude.databinding.FragmentLoginBinding

class Login : Fragment() {

    private lateinit var binding: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)

        binding.buttonCadastrar.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_cadastro_usuario)
        }

        // obervar a variavel de email != String

        binding.buttonEntrar.setOnClickListener {

            // Fazer a verificação se o usuario existe
            findNavController().navigate(R.id.action_login_to_listFragment)
        }


        return binding.root
    }

}
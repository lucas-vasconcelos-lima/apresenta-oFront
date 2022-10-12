package com.example.doesaude

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.doesaude.databinding.FragmentCadastroUsuarioBinding

class CadastroUsuario : Fragment() {

    private lateinit var binding: FragmentCadastroUsuarioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCadastroUsuarioBinding.inflate(layoutInflater, container, false)


        binding.buttonUserAvancar.setOnClickListener{
            proxTela()
        }

        return binding.root
    }

    private fun validarCampos(nome: String, cpf: String, email: String,
                              senha: String, confirmSenha: String): Boolean{
        //dataNasc: String

        return !(
                (nome == "" || nome.length < 5 || nome.length > 150) ||
                        (cpf == "" || cpf.length != 11) ||
                        (email == "" || email.length < 5 || email.length > 100) ||
                        (senha ==  "" || senha.length < 3 || senha.length > 50) ||
                (confirmSenha != senha)
                //(dataNasc == "")
                )
    }

    private fun proxTela(){
        val nome = binding.textNome.text.toString()
        val cpf = binding.textCpf.text.toString()
        val email = binding.textEmail.text.toString()
        val senha = binding.textSenha.text.toString()
        val confirmSenha = binding.textSenhaConfirm.text.toString()
        //val dataNasc = binding.textNome.text.toString()

        if(validarCampos(nome, cpf, email, senha, confirmSenha)){
            findNavController().navigate(R.id.action_cadastro_usuario_to_cadastro_endereco)

        }else{
            Toast.makeText(context, "Verifique os campos!", Toast.LENGTH_LONG).show()
        }
    }

}
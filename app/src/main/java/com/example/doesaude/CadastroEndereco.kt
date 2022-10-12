package com.example.doesaude

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.doesaude.databinding.FragmentCadastroEnderecoBinding
import com.example.doesaude.databinding.FragmentCadastroUsuarioBinding
import com.example.doesaude.model.Endereco
import com.example.doesaude.model.Usuario

class CadastroEndereco : Fragment() {

    private lateinit var binding: FragmentCadastroEnderecoBinding
    private lateinit var bindingUser: FragmentCadastroUsuarioBinding
    private val mainViewModel: MainViewModel by activityViewModels()



    override fun onCreateView  (
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCadastroEnderecoBinding.inflate(layoutInflater, container, false)
        bindingUser = FragmentCadastroUsuarioBinding.inflate(layoutInflater, container, false)

        binding.buttonEndFinalizar.setOnClickListener{
            findNavController().navigate(R.id.action_cadastro_endereco_to_listFragment)
            inserirNoBanco()
        }
        return binding.root
    }


    private fun validarCampos(cep: String, endereco: String, cidade: String,
                              bairro: String, numero: String): Boolean{

        return !(
                (cep == "" || cep.length > 7) ||
                        (endereco == "" || endereco.length > 255) ||
                        (cidade == "" || cidade.length > 255) ||
                        (bairro == "" || bairro.length >255) ||
                        (numero == "" || numero.length > 8)
                )
    }

    private fun inserirNoBanco(){

        // Dados - Tela de Cadastro Endereço
        val cep = binding.textCep.text.toString()
        val logradouro = binding.textEndereco.text.toString()
        val cidade = binding.textCidade.text.toString()
        val bairro = binding.textBairro.text.toString()
        val numero = binding.textNumero.text.toString()

        // Dados - Tela de Cadastro Usuario
        val nome = bindingUser.textNome.text.toString()
        val cpf = bindingUser.textCpf.text.toString()
        val email = bindingUser.textEmail.text.toString()
        val senha = bindingUser.textSenha.text.toString()
        val telefone = binding.textTelefone.text.toString()
        val dataNasc = bindingUser.textDataNasc.text.toString()
        val endereco = Endereco(0, cep, logradouro, cidade, bairro, numero, null)

        if(validarCampos(cep, logradouro, cidade, bairro, numero)){
            val usuario = Usuario(0, nome, cpf, email, telefone, senha, dataNasc, endereco)
            mainViewModel.adicionarUser(usuario)
            mainViewModel.adicionarEndereco(endereco)
            findNavController().navigate(R.id.action_cadastro_endereco_to_listFragment)

        }else{
            Toast.makeText(context, "Verifique os campos", Toast.LENGTH_LONG).show()
        }



    }
}
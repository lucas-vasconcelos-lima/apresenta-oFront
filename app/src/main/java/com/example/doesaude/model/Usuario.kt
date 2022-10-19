package com.example.doesaude.model

data class Usuario (
    var id: Long,
    var email: String,
    var nome: String,
    var cpf: String,
    //var telefone: String,
    var senha: String,
    var confirmSenha: String,
    var dataNascimento: String,
    //var endereco: String
        ) {
}
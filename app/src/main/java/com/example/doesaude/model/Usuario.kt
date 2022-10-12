package com.example.doesaude.model

class Usuario(
    val id: Long,
    var nome: String,
    val cpf: String,
    var email: String,
    var telefone: String,
    var senha: String,
    var dataNasc: String,
    var endereco: Endereco
) {
}
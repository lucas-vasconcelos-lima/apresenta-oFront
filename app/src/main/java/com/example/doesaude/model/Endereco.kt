package com.example.doesaude.model

class Endereco(
    val id: Long,
    var cep: String,
    var logradouro: String,
    var cidade: String,
    var bairro: String,
    var numero: String,
    var usuario: List<Usuario>?
) {
}
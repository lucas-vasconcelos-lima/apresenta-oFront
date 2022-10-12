package com.example.doesaude.api

import com.example.doesaude.model.Categoria
import com.example.doesaude.model.Endereco
import com.example.doesaude.model.Postagem
import com.example.doesaude.model.Usuario
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("categoria")
    suspend fun listCategoria(): Response<List<Categoria>>

    @POST("endereco")
    suspend fun addEndereco(@Body endereco: Endereco): Response<Endereco>

    @POST("usuario")
    suspend fun addUser(@Body usuario: Usuario): Response<Usuario>

    @POST("postagem")
    suspend fun addPostagem(@Body postagem: Postagem): Response<Postagem>

    @GET("postagem")
    suspend fun listPostagem(): Response<List<Postagem>>

    @PUT("postagem")
    suspend fun updateTarefa(@Body postagem: Postagem): Response<Postagem>

    @DELETE("postagem/{id}")
    suspend fun deletePostagem(@Path("id") id: Long): Response<Postagem>

}
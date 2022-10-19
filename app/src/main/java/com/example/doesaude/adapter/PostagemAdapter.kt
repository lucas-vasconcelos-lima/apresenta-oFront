package com.example.doesaude.adapter

import android.app.AlertDialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.doesaude.MainViewModel
import com.example.doesaude.databinding.CardLayoutBinding
import com.example.doesaude.model.Postagem

class PostagemAdapter(
    val taskClickListener: TaskClickListener,
    val mainViewModel: MainViewModel,
    val context: Context
) : RecyclerView.Adapter<PostagemAdapter.PostagemViewHolder>(){


    private var listPostagem = emptyList<Postagem>()

    class PostagemViewHolder(val binding: CardLayoutBinding): RecyclerView.ViewHolder(binding.root){}

    //CRIARÁ COM BASE NO CARD
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostagemViewHolder {
        return PostagemViewHolder(CardLayoutBinding.inflate(LayoutInflater.from(parent.context)
            , parent, false))
    }

    //COMO IRÁ PROCESSAR DENTRO DO CARD
    override fun onBindViewHolder(holder: PostagemViewHolder, position: Int) {
        val postagem = listPostagem[position]

        holder.binding.textTitulo.text = postagem.titulo
        holder.binding.textDesc.text = postagem.descricao
        holder.binding.textCategoria.text = postagem.categoria.tipo

        Glide
            .with(context)
            .load(postagem.imagem)
            .placeholder(android.R.drawable.ic_menu_report_image)
            .into(holder.binding.imagePostagem)

        holder.binding.buttonEditPost.setOnClickListener {
            taskClickListener.onTaskClickListener(postagem)
        }
       /*
        holder.itemView.setOnClickListener {
            taskClickListener.onTaskClickListener(postagem)
        }
*/
        holder.binding.buttonDeletar.setOnClickListener {
            showAlertDialog(postagem.id)
        }

    }

    override fun getItemCount(): Int {
        return listPostagem.size
    }

    //SETTAR LISTA
    fun setList(list: List<Postagem>){
        listPostagem = list.sortedByDescending { it.id }
        notifyDataSetChanged()
    }

    private fun showAlertDialog(id: Long){
        AlertDialog.Builder(context)
            .setTitle("Excluir postagem?")
            .setMessage("Certeza que deseja excluir a postagem?")
            .setPositiveButton("Sim"){
                _,_ -> mainViewModel.deletarPostagem(id)
            }
            .setNegativeButton("Não"){
                _,_ ->
            }.show()
    }
}
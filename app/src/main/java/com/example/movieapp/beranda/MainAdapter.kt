package com.example.movieapp.beranda

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.ItemDataBinding
import com.example.repository.repository.local.model.Movie
import com.google.android.material.imageview.ShapeableImageView

class MainAdapter(private val list: ArrayList<Movie>)
    : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private lateinit var context: Context
    var onDetail: (movie: Movie) -> Unit = {}

    class ViewHolder(val binding: ItemDataBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemDataBinding.inflate(layoutInflater, parent, false)
        context = parent.context
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.tvTitleMovie.text = item.title
        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w500"+item.posterPath)
            .into(holder.binding.imgMovie)
        holder.itemView.setOnClickListener {
            onDetail(item)
        }
        cekStatus(holder.binding.iconAdults, item.adult)
    }

    override fun getItemCount(): Int = list.size

    private fun cekStatus(icon: ShapeableImageView, isAdults: Boolean?) {
        when (isAdults){
            true -> icon.isVisible = true
            else -> icon.isVisible = false
        }
    }
}
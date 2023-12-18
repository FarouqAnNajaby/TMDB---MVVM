package com.example.movieapp.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.ActivityDetailBinding
import com.example.movieapp.model.Extra
import com.example.repository.repository.local.model.Movie
import com.example.repository.repository.remote.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val viewModel by viewModel<DetailViewModel>()
    private var id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        id = intent.getIntExtra(Extra.DATA,0)
        viewModel.getMovie(id).observe(this) {
            binding.loadingView.isVisible = it is Resource.Loading
            if (it is Resource.Error) {
                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                Log.i("errorcok", "onCreate: ${it.message}")
            }
            else if (it is Resource.SuccessNothing){
                val data = viewModel.getMovieFromLocal(id)
                setUpView(data)
            }
        }

    }

    private fun setUpView(movie: Movie?) {
        Glide.with(this@DetailActivity)
            .load("https://image.tmdb.org/t/p/w500"+movie?.posterPath)
            .into(binding.imgMovie)
        binding.tvFillOverview.text = movie?.overview ?: ""
        binding.tvFillPopularity.text = movie?.popularity.toString()
        binding.tvFillPrice.text = movie?.budget.toString()
        binding.tvFillRelease.text = movie?.releaseDate ?: ""
        binding.tvFillTitle.text = movie?.title
    }
}
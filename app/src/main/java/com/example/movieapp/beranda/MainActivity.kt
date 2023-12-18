package com.example.movieapp.beranda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.detail.DetailActivity
import com.example.movieapp.model.Extra
import com.example.repository.repository.local.model.Movie
import com.example.repository.repository.remote.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val movieList = arrayListOf<Movie>()
    private val viewModel by viewModel<MainViewModel>()
    private val adapter = MainAdapter(movieList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (viewModel.getMoviesFromLocal().isNotEmpty()) showData() else syncData()

    }

    private fun syncData() {
        viewModel.getMovies().observe(this) {
            binding.loadingView.isVisible = it is Resource.Loading
            if (it is Resource.Error) {
                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                Log.i("errorcok", "onCreate: ${it.message}")
            }
            else if (it is Resource.SuccessNothing){
                movieList.clear()
                movieList.addAll(viewModel.getMoviesFromLocal())
                showData()
            }
        }
    }

    private fun showData(){
        movieList.addAll(viewModel.getMoviesFromLocal())
        binding.rvMovie.layoutManager = GridLayoutManager(this,2)
        binding.rvMovie.adapter = adapter
        adapter.onDetail = {
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra(Extra.DATA, it.id)
            startActivity(intent)
        }
    }
}
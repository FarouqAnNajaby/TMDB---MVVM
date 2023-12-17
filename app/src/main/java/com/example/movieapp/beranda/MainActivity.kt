package com.example.movieapp.beranda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.movieapp.R
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.repository.repository.remote.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getMovies().observe(this) {
//            binding.loadingView.isVisible = it is Resource.Loading

            if (it is Resource.Success) {
//                Toast.makeText(this, it.data.toString(), Toast.LENGTH_SHORT).show()
            } else if (it is Resource.Error) {
                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
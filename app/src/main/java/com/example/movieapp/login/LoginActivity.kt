package com.example.movieapp.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.movieapp.R
import com.example.movieapp.beranda.MainActivity
import com.example.movieapp.databinding.ActivityLoginBinding
import com.example.repository.repository.remote.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel by viewModel<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (viewModel.isLoggedIn()) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


        binding.btnLogin.setOnClickListener { validationLogin() }
    }

    private fun validationLogin() {
        if (!isValidEmail(binding.edtEmail.text.toString())){
            Toast.makeText(this, R.string.email_empty, Toast.LENGTH_SHORT).show()
        }
        else if (!isValidPassword(binding.edtPass.text.toString())){
            Toast.makeText(this, R.string.password_empty, Toast.LENGTH_SHORT).show()
        }
        else{
            viewModel.loginWithEmail(
                binding.tvName.text.toString(),
                binding.tvEmail.text.toString(),
                binding.tvPassword.text.toString()
            ).observe(this) {
                binding.loadingView.isVisible = it is Resource.Loading
                if (it is Resource.SuccessNothing) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPassword(password: String): Boolean {
        if (password.length < 6) return false
        if (password.filter { it.isLetter() }.filter { it.isUpperCase() }.firstOrNull() == null) return false
        if (password.filter { it.isLetter() }.filter { it.isLowerCase() }.firstOrNull() == null) return false
        if (password.firstOrNull { !it.isLetterOrDigit() } == null) return false

        return true
    }
}
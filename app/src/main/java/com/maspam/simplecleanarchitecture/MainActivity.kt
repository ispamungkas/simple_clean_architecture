package com.maspam.simplecleanarchitecture

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.maspam.simplecleanarchitecture.databinding.ActivityMainBinding
import com.maspam.simplecleanarchitecture.presentation.viewmodel.MainViewModel
import com.maspam.simplecleanarchitecture.presentation.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val factory = MainViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        viewModel.setMessage("Maspam")
        viewModel.message.observe(this) {
            binding?.tvWelcome?.text = it.welcomeMessage
        }
    }
}
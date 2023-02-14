package com.task.unlimint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.task.unlimint.databinding.ActivityMainBinding
import com.task.unlimint.viewmodel.JokesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private val jokesViewModel:JokesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        getJokes()
        val adapter = JokesAdapter()
        binding.jokesRv.adapter=adapter
        jokesViewModel.jokesData.observe(this) { jokesList ->
            adapter.submitList(jokesList)
        }
    }

    private fun getJokes() {
        jokesViewModel.getJokes()
    }
}
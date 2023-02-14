package com.task.unlimint

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.task.unlimint.databinding.JokesItemViewBinding

class JokesAdapter():ListAdapter<String, JokesAdapter.JokesViewHolder>(JokesDiffCallback()) {
    inner class JokesViewHolder(private val binding:JokesItemViewBinding):ViewHolder(binding.root){
        fun bind(joke:String){
            binding.jokeText.text=joke
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        JokesViewHolder(
            JokesItemViewBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )

    override fun onBindViewHolder(holder: JokesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class JokesDiffCallback:DiffUtil.ItemCallback<String>(){
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem==newItem
        }

    }
}
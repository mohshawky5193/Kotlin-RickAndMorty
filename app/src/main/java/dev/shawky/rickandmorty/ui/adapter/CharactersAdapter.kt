package dev.shawky.rickandmorty.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import dev.shawky.rickandmorty.databinding.ItemListCharacterBinding
import dev.shawky.rickandmorty.model.Character;

class CharactersAdapter:PagingDataAdapter<Character,CharactersViewHolder>(CHARACTER_COMPRATOR) {
    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding =ItemListCharacterBinding.inflate(inflater)
        return CharactersViewHolder(binding)
    }
}

object CHARACTER_COMPRATOR : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem == newItem
    }

}

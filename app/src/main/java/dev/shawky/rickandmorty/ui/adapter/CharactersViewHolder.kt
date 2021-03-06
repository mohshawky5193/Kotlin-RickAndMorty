package dev.shawky.rickandmorty.ui.adapter

import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import dev.shawky.rickandmorty.R
import dev.shawky.rickandmorty.databinding.ItemListCharacterBinding
import dev.shawky.rickandmorty.model.Character;

class CharactersViewHolder(val binding:ItemListCharacterBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Character?) {
        binding.character= item
        binding.characterOnClickListener = View.OnClickListener {
            val characterId = bundleOf("characterId" to item?.id)
            Navigation.findNavController(binding.root).navigate(R.id.characterDetailFragment,characterId)
        }
        binding.executePendingBindings()
    }

}

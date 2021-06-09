package dev.shawky.rickandmorty.ui.adapter

import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import dev.shawky.rickandmorty.R
import dev.shawky.rickandmorty.databinding.ItemListCharacterBinding
import dev.shawky.rickandmorty.model.Character;

class CharactersViewHolder(val binding:ItemListCharacterBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Character?) {
        ViewCompat.setTransitionName(binding.textViewCharacterName,"character_name${item?.id}")
        ViewCompat.setTransitionName(binding.imageViewCharacterImage,"character_image${item?.id}")
        binding.character= item
        binding.executePendingBindings()
        binding.characterOnClickListener = View.OnClickListener {
            val characterId = bundleOf("characterId" to item?.id)
            val extras = FragmentNavigatorExtras(
                binding.textViewCharacterName to "character_name${item?.id}",
                binding.imageViewCharacterImage to "character_image${item?.id}"
            )
            Navigation.findNavController(binding.root).navigate(R.id.characterDetailFragment,characterId,null,extras)
        }
        binding.executePendingBindings()
    }

}

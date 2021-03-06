package dev.shawky.rickandmorty.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

class Binding {

    companion object {
        @BindingAdapter("imageUrl")
        @JvmStatic
        fun setImage(view: ImageView, url: String?) {
            if(url != null) {
                Glide.with(view.context)
                    .load(url)
                    .into(view)
            }else{
               view.setImageResource(android.R.drawable.star_big_on);
            }
        }
    }
}
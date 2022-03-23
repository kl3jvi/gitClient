package com.kl3jvi.payconiq.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.request.CachePolicy
import com.kl3jvi.payconiq.R

object ViewBindings {
    @JvmStatic
    @BindingAdapter("image")
    fun setImage(image: ImageView, url: String?) {
        if (!url.isNullOrEmpty()) {
            image.load(url) {
                crossfade(true)
                diskCachePolicy(CachePolicy.ENABLED)
                placeholder(R.drawable.ic_no_image)
                error(R.drawable.ic_no_image)
            }
        }
    }
}
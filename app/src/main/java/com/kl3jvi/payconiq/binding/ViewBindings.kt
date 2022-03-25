package com.kl3jvi.payconiq.binding

import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.core.graphics.drawable.toBitmap
import androidx.databinding.BindingAdapter
import androidx.palette.graphics.Palette
import coil.load
import coil.request.CachePolicy
import com.google.android.material.imageview.ShapeableImageView
import com.kl3jvi.payconiq.R

object ViewBindings {
    @JvmStatic
    @BindingAdapter("paletteImage", "paletteView")
    fun setImagePalette(view: AppCompatImageView, url: String?, palettePlaceholder: View) {
        if (!url.isNullOrEmpty()) {
            view.load(url) {
                crossfade(true)
                diskCachePolicy(CachePolicy.ENABLED)
                placeholder(R.drawable.ic_no_image)
                error(R.drawable.ic_no_image)
                allowHardware(false)
                listener(
                    onSuccess = { _, _ ->
                        // Create the palette on a background thread.
                        val palette = Palette.from(view.drawable.toBitmap()).generate()
                        val color = palette.dominantSwatch?.rgb
                        color?.let {
                            if (palettePlaceholder is CardView) {
                                palettePlaceholder.setCardBackgroundColor(color)
                            } else if (palettePlaceholder is ShapeableImageView) {
                                palettePlaceholder.setBackgroundColor(color)
                            }
                        }
                    }
                )
            }
        }
    }
}




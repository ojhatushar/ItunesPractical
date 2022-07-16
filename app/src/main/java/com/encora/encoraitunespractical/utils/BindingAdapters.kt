package com.encora.encoraitunespractical.utils

import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.encora.encoraitunespractical.R


object BindingAdapters {

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, imageURL: String?) {
        Glide.with(imageView.context)
            .load(imageURL)
            .placeholder(R.drawable.ic_placeholder)
            .into(imageView)
    }

}
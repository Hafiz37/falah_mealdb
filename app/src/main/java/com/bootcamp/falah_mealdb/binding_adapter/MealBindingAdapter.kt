package com.example.rawgbootcampidn.binding_adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.rawgbootcampidn.R
object MealBindingAdapter {
    @BindingAdapter("loadImageFromUrl")
    @JvmStatic
    fun loadImageFromUrl(imageView: ImageView, imageUrl: String?) {
        val placeHolderDrawable = R.drawable.img_placeholder
        Glide.with(imageView.context).load(imageUrl).placeholder(placeHolderDrawable)
            .error(placeHolderDrawable)
            .into(imageView)
    }

//    @BindingAdapter("setStrArea")
//    @JvmStatic
//    fun setStrArea(textView: TextView, areas: List<strArea?>?) {
//        val textStrArea =
//            areas?.map { area -> area?.name }?.joinToString(
//                separator = " ",
//                limit = 3,
//                truncated = "..."
//            )
//        textView.text = textStrArea
//    }


}

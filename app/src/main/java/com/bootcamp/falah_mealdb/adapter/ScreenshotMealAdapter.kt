package com.bootcamp.falah_mealdb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rawgbootcampidn.databinding.ScreenshotLayoutBinding

class ScreenshotMealAdapter(private val listScreenshotMeal : ArrayList<Meal>) : RecyclerView.Adapter<ScreenshotMealAdapter.ScreenshotViewHolder>() {

    inner class ScreenshotViewHolder(val binding : ScreenshotLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(meal: Meal) {
            TODO("Not yet implemented")
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScreenshotViewHolder {
        return ScreenshotViewHolder(ScreenshotLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return listScreenshotMeal.size
    }

    override fun onBindViewHolder(holder: ScreenshotViewHolder, position: Int) {
        return holder.bind(listScreenshotMeal[position])
    }
}
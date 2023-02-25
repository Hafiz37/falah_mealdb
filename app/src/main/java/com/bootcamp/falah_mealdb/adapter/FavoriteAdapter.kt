package com.bootcamp.falah_mealdb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.falah_mealdb.model.MealsItems
import com.example.rawgbootcampidn.databinding.FavoriteMealRowLayoutBinding

class FavoriteAdapter() : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    private val listFavoriteMeal : List<MealsItems> = listOf()
    inner class FavoriteViewHolder(val binding: FavoriteMealRowLayoutBinding) : RecyclerView.ViewHolder(binding.root)  {

        fun bind(mealDetails: MealsItems) {
            binding.apply {
            mealDetail = mealDetails
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(FavoriteMealRowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return listFavoriteMeal.size
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        return holder.bind(listFavoriteMeal[position])

    }
}
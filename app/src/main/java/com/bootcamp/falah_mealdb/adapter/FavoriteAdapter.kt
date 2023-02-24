package com.bootcamp.falah_mealdb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rawgbootcampidn.databinding.FavoriteMealRowLayoutBinding

class FavoriteAdapter(private val listFavoriteMeal : ArrayList<Meal>) : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {
    inner class FavoriteViewHolder(val binding: FavoriteMealRowLayoutBinding) : RecyclerView.ViewHolder(binding.root)  {

        fun bind(meal: Meal) {
            TODO("Not yet implemented")
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
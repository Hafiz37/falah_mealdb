package com.bootcamp.falah_mealdb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.falah_mealdb.data.Meal
import com.example.rawgbootcampidn.databinding.MealRowLayoutBinding

class ListMealsAdapter(private val listMeal: ArrayList<Meal>) : RecyclerView.Adapter<ListMealsAdapter.ListViewHolder>() {

    inner class ListViewHolder(val binding: MealRowLayoutBinding) :RecyclerView.ViewHolder(binding.root) {

        fun bind(meal: Meal) {
            TODO("Not yet implemented")
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(MealRowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return listMeal.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        return holder.bind(listMeal[position])
    }


}
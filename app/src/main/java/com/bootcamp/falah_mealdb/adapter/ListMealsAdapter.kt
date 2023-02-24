package com.bootcamp.falah_mealdb.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.falah_mealdb.ui.DetailActivity
import com.bootcamp.falah_mealdb.model.MealsItem
import com.example.rawgbootcampidn.databinding.MealRowLayoutBinding

class ListMealsAdapter() : RecyclerView.Adapter<ListMealsAdapter.ListViewHolder>() {

    private var listMeal: List<MealsItem> = listOf()
    inner class ListViewHolder(val binding: MealRowLayoutBinding) :RecyclerView.ViewHolder(binding.root) {


        fun bind(meal: MealsItem) {
            binding.apply {
                data = meal
                binding.latestMealItemWrapper.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MEAL, meal)
                    itemView.context.startActivity(intent)
                }
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val rowBinding = MealRowLayoutBinding.inflate(layoutInflater, parent, false)
        return ListViewHolder(rowBinding)
    }

    override fun getItemCount(): Int {
        return listMeal.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        return holder.bind(listMeal[position])
    }

    fun setData(data : List<MealsItem>){
        listMeal = data as ArrayList<MealsItem>
        notifyDataSetChanged()
    }


}
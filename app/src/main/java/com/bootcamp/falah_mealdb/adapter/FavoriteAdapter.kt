package com.bootcamp.falah_mealdb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.falah_mealdb.data.database.MealEntity
import com.bootcamp.falah_mealdb.model.MealsItems
import com.example.rawgbootcampidn.databinding.FavoriteMealRowLayoutBinding

class FavoriteAdapter() : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    private val diffCallBack = object : DiffUtil.ItemCallback<MealEntity>() {
        override fun areItemsTheSame(oldItem: MealEntity, newItem: MealEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MealEntity, newItem: MealEntity): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallBack)
    private lateinit var onFavoriteItemCallBack: IOnFavoriteItemCallB

    private val listFavoriteMeal : List<MealsItems> = listOf()
    inner class FavoriteViewHolder(val binding: FavoriteMealRowLayoutBinding) : RecyclerView.ViewHolder(binding.root)  {

        fun bind(item: MealEntity) {
            binding.apply {
                    mealDetail = item
                itemView.setOnClickListener {
                    onFavoriteItemCallBack.onFavoriteItemClickCallback(item)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val rowBinding = FavoriteMealRowLayoutBinding.inflate(layoutInflater, parent, false)
        return FavoriteViewHolder(rowBinding)
    }

    override fun getItemCount(): Int {
        return listFavoriteMeal.size
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
//        return holder.bind(listFavoriteMeal[position])
        val itemData = differ.currentList[position]
        holder.bind(itemData)
    }

    fun setData(list: List<MealEntity?>?) {
        differ.submitList(list)
    }

    interface IOnFavoriteItemCallB {
        fun onFavoriteItemClickCallback(data: MealEntity)
    }

    fun setOnItemClickCallback(action: IOnFavoriteItemCallBack) {
        this.onFavoriteItemCallBack = action
    }

    interface IOnFavoriteItemCallBack : IOnFavoriteItemCallB {
        override fun onFavoriteItemClickCallback(data: MealEntity)
    }

}
package com.bootcamp.falah_mealdb.ui

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.bootcamp.falah_mealdb.adapter.FavoriteAdapter
import com.bootcamp.falah_mealdb.data.database.MealEntity
import com.bootcamp.falah_mealdb.viewModel.FavoriteViewModel
import com.example.rawgbootcampidn.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {

    private val favoriteAdapter by lazy { FavoriteAdapter() }
    private val favoriteViewModel by viewModels<FavoriteViewModel>()
    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.apply {
            title = "Favorite"
            setBackgroundDrawable(ColorDrawable(Color.parseColor("#3282B8")))
            setDisplayHomeAsUpEnabled(true)
        }

        favoriteViewModel.favoriteMealList.observe(this) { result ->
            if (result.isEmpty()) {
                binding.apply {
                    rvFavoriteMeal.isVisible = false
                    emptyIcon.isVisible = true
                    emptyTv.isVisible = true
                }
            } else {
                binding.apply {
                    rvFavoriteMeal.apply {
                        adapter = favoriteAdapter
                        layoutManager = LinearLayoutManager(this@FavoriteActivity)
                    }
                }
                favoriteAdapter.apply {
                    setData(result)
                    setOnItemClickCallback(object : FavoriteAdapter.IOnFavoriteItemCallBack {
                        override fun onFavoriteItemClickCallback(data: MealEntity) {
                            val intent = Intent(this@FavoriteActivity, FavoriteDetailActifity::class.java)
                            intent.putExtra(FavoriteDetailActifity.EXTRA_FAVORITE_MEAL, data)
                            startActivity(intent)
                        }
                    })
                }
            }
        }



    }

}
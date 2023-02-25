package com.bootcamp.falah_mealdb.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bootcamp.falah_mealdb.adapter.FavoriteAdapter
import com.bootcamp.falah_mealdb.adapter.ListMealsAdapter
import com.example.rawgbootcampidn.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {

    private val mealAdapter by lazy {
        FavoriteAdapter()
    }

    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteBinding.inflate(layoutInflater)

        setContentView(binding.root)

    }
}
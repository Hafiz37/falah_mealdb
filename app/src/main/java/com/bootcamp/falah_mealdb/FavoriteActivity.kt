package com.bootcamp.falah_mealdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rawgbootcampidn.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteBinding.inflate(layoutInflater)

        setContentView(binding.root)

    }
}
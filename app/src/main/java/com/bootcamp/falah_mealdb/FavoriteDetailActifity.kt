package com.bootcamp.falah_mealdb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.rawgbootcampidn.databinding.ActivityFavoriteDetailBinding

class FavoriteDetailActifity : AppCompatActivity() {

    private lateinit var binding : ActivityFavoriteDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}
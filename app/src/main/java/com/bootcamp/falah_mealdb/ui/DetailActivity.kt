package com.bootcamp.falah_mealdb.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bootcamp.falah_mealdb.model.MealsItems
import com.example.rawgbootcampidn.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val meal = intent.getParcelableExtra<MealsItems>(EXTRA_MEAL)!!

        supportActionBar?.apply {
            title = "Meals"
            setDisplayHomeAsUpEnabled(true)
        }

    }

    companion object{
        const val EXTRA_MEAL = "meal"
    }

}
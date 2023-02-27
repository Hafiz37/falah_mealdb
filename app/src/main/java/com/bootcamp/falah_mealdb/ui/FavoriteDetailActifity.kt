package com.bootcamp.falah_mealdb.ui

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bootcamp.falah_mealdb.data.database.MealEntity
import com.bootcamp.falah_mealdb.viewModel.FavoriteDetailViewModel
import com.example.rawgbootcampidn.R
import com.example.rawgbootcampidn.databinding.ActivityFavoriteDetailBinding

class FavoriteDetailActifity : AppCompatActivity() {

    private lateinit var binding : ActivityFavoriteDetailBinding
    private val favoriteDetailViewModel by viewModels<FavoriteDetailViewModel>()

    companion object {
        const val EXTRA_FAVORITE_MEAL = "favorite_meal"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.apply {
            title = "Meal Detail"
            setBackgroundDrawable(ColorDrawable(Color.parseColor("#3282B8")))
            setDisplayHomeAsUpEnabled(true)
        }

        val favoriteMeal = intent.getParcelableExtra<MealEntity>(EXTRA_FAVORITE_MEAL)
        binding.mealDetail = favoriteMeal?.meal?.meals!![0]

        binding.apply {
            addFavoriteBtn.apply {
//                setImageResource(R.drawable.ic_favorite)
                setOnClickListener {
                    deleteFavoriteMeal(favoriteMeal)
                    val intent = Intent(this@FavoriteDetailActifity, FavoriteActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }


    }


    private fun deleteFavoriteMeal(mealEntity: MealEntity) {
        favoriteDetailViewModel.deleteFavoriteMeal(mealEntity)
        Toast.makeText(this, "Successfully remove from bookmark(s)", Toast.LENGTH_SHORT).show()
    }

}
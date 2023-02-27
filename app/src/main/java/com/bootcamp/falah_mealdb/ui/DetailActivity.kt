package com.bootcamp.falah_mealdb.ui

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.bootcamp.falah_mealdb.data.database.MealEntity
import com.bootcamp.falah_mealdb.data.network.handler.NetworkResult
import com.bootcamp.falah_mealdb.model.MealDetail
import com.bootcamp.falah_mealdb.model.MealsItems
import com.bootcamp.falah_mealdb.viewModel.DetailViewModel
import com.example.rawgbootcampidn.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var mealDetail: MealDetail
    private val detailViewModel by viewModels<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val meal = intent.getParcelableExtra<MealsItems>(EXTRA_MEAL)!!

        supportActionBar?.apply {
            title = "Meals"
            setBackgroundDrawable(ColorDrawable(Color.parseColor("#2970A0")))
            setDisplayHomeAsUpEnabled(true)
        }

        detailViewModel.fetchMealDetail(meal?.idMeal as String)

        detailViewModel.mealDetail.observe(this) { res ->
            when (res) {
                is NetworkResult.Loading -> {
                    handleUi(wrapper = false, progress = true, errorTv = false)
                }
                is NetworkResult.Error -> {
                    handleUi(wrapper = false, progress = false, errorTv = true)
                }
                is NetworkResult.Success -> {
                    val selectedMeal = res.data?.meals!![0]
                    binding.meals = selectedMeal
                    mealDetail = res.data!!
                    handleUi(wrapper = true, progress = false, errorTv = false)
                }

//                is NetworkResult.Success -> {
//                    val data = res.data?.meals?.get(0)
//                    mealDetail = res.data?.meals?.get(0)!!
//                    binding.apply {
//                        mealDetail = data
//                    }
//                    handleUi(wrapper = true, progress = false, errorTv = false)
//                }

                else -> {}
            }
        }

        isFavoriteMeal(meal)
    }

    private fun handleUi(
        wrapper: Boolean,
        progress: Boolean,
        errorTv: Boolean
    ) {
        binding.apply {
            mealDetailWrapper.isVisible = wrapper
            progressBar.isVisible = progress
            errorText.isVisible = errorTv
        }
    }

    private fun isFavoriteMeal(mealSelected: MealsItems) {
        detailViewModel.favoriteMealList.observe(this) { result ->
            val meal = result.find { favorite ->
                favorite.meal.meals!![0]?.idMeal == mealSelected.idMeal
            }
            if (meal != null) {
                binding.addFavoriteBtn.apply {
                    setOnClickListener {
                        deleteFavoriteMeal(meal.id)
                    }
                }
            } else {
                binding.addFavoriteBtn.apply {
                    setOnClickListener {
                        insertFavoriteMeal()
                    }
                }
            }
        }
    }

    private fun insertFavoriteMeal() {
        val mealEntity = MealEntity(meal = mealDetail)
        detailViewModel.insertFavoriteMeal(mealEntity)
        Toast.makeText(this, "Successfully add to bookmark(s)", Toast.LENGTH_SHORT).show()
    }

    private fun deleteFavoriteMeal(mealEntityId: Int) {
        val mealEntity = MealEntity(mealEntityId, mealDetail)
        detailViewModel.deleteFavoriteMeal(mealEntity)
        Toast.makeText(this, "Successfully remove from bookmark(s)", Toast.LENGTH_SHORT).show()
    }

    private fun openWeb(url: String?) {
        val intent = Intent()
        intent.apply {
            action = Intent.ACTION_VIEW
            data = Uri.parse(url)
        }
        startActivity(intent)
    }


    companion object{
        const val EXTRA_MEAL = "meal"
    }

}
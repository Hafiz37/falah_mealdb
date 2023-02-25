package com.bootcamp.falah_mealdb.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.bootcamp.falah_mealdb.adapter.ListMealsAdapter
import com.bootcamp.falah_mealdb.data.metwork.handler.NetworkResult
import com.bootcamp.falah_mealdb.model.MealsItems
import com.bootcamp.falah_mealdb.viewModel.MainViewModel
import com.example.rawgbootcampidn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()
    private val mealAdapter by lazy {
        ListMealsAdapter()
    }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        binding.favoriteIcon.setOnClickListener{
            val intent = Intent(this@MainActivity, FavoriteActivity::class.java)
            startActivity(intent)
        }



        mainViewModel.mealList.observe(this@MainActivity) { res ->
            when (res) {
                is NetworkResult.Loading -> {
                    handleUi(
                        recyclerView = false,
                        progressBar = true,
                        errorTv = false
                    )
                }
                is NetworkResult.Error -> {
                    handleUi(
                        recyclerView = false,
                        progressBar = false,
                        errorTv = true
                    )
                }
                is NetworkResult.Success -> {
                    val mealAdapter = ListMealsAdapter()
                    mealAdapter.setData(res.data?.meals as List<MealsItems>)

                    binding.rvBestMeal.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        setHasFixedSize(true)
                        adapter = mealAdapter
                    }

                    handleUi(
                        recyclerView = true,
                        progressBar = false,
                        errorTv = false
                    )
                }
            }
        }

//        ApiConfig.gerService().getMeal().enqueue(object : Callback<ResponseMeal>{
//            override fun onResponse(call: Call<ResponseMeal>, response: Response<ResponseMeal>) {
//                if (response.isSuccessful){
//                    val responseMeal = response.body()
//                    val dataMeal = responseMeal?.meals
//                    val mealAdapter = ListMealsAdapter()
//                    mealAdapter.setData(dataMeal as List<MealsItems>)
//
//                    binding.rvBestMeal.apply {
//                        layoutManager = LinearLayoutManager(this@MainActivity)
//                        setHasFixedSize(true)
//                        adapter = mealAdapter
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<ResponseMeal>, t: Throwable) {
//                Log.d("gagal", "onFailure: " + t.localizedMessage)
//            }
//
//        })



    }

    private fun handleUi(
        recyclerView: Boolean,
        progressBar: Boolean,
        errorTv: Boolean
    ) {
        binding.apply {
            rvBestMeal.isVisible = recyclerView
            progressbar.isVisible = progressBar
            errorText.isVisible = errorTv
        }
    }
}
package com.bootcamp.falah_mealdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.bootcamp.falah_mealdb.adapter.ListMealsAdapter
import com.bootcamp.falah_mealdb.data.metwork.config.ApiConfig
import com.bootcamp.falah_mealdb.model.MealsItem
import com.bootcamp.falah_mealdb.model.ResponseMeal
import com.example.rawgbootcampidn.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ApiConfig.gerService().getMeal().enqueue(object : Callback<ResponseMeal>{
            override fun onResponse(call: Call<ResponseMeal>, response: Response<ResponseMeal>) {
                if (response.isSuccessful){
                    val responseMeal = response.body()
                    val dataMeal = responseMeal?.meals
                    val mealAdapter = ListMealsAdapter()
                    mealAdapter.setData(dataMeal as List<MealsItem>)

                    binding.rvBestMeal.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        setHasFixedSize(true)
                        adapter = mealAdapter
                    }
                }
            }

            override fun onFailure(call: Call<ResponseMeal>, t: Throwable) {
                Log.d("gagal", "onFailure: " + t.localizedMessage)
            }

        })

    }
}
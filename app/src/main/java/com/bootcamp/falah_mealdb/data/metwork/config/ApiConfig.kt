package com.bootcamp.falah_mealdb.data.metwork.config

import com.bootcamp.falah_mealdb.data.metwork.api.MealApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiConfig {

    const val baseUrl = "https://www.themealdb.com/api/json/v1/1/"

    private fun getRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun gerService() : MealApi{
        return getRetrofit().create(MealApi::class.java)
    }

}
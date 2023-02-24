package com.bootcamp.falah_mealdb.data.metwork

import com.bootcamp.falah_mealdb.data.metwork.api.MealApi
import com.bootcamp.falah_mealdb.data.metwork.config.ApiConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Service {

//    private fun getRetrofit() : Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(ApiConfig.baseUrl)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }


    private val retrofit by lazy {
        Retrofit.Builder().baseUrl(ApiConfig.baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
    }

    val MealService: MealApi by lazy {
        retrofit.create(MealApi::class.java)
    }


}
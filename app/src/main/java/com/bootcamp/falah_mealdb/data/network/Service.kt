package com.bootcamp.falah_mealdb.data.network

import com.bootcamp.falah_mealdb.data.network.api.MealApi
import com.bootcamp.falah_mealdb.utils.Constant.BASE_URL
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
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }

    val mealService: MealApi by lazy {
        retrofit.create(MealApi::class.java)
    }


}
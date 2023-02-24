package com.bootcamp.falah_mealdb.data.metwork.api

import com.bootcamp.falah_mealdb.model.ResponseMeal
import retrofit2.Call
import retrofit2.http.GET

interface MealApi {

    @GET("filter.php?c=Seafood")
    fun getMeal() : Call<ResponseMeal>
}
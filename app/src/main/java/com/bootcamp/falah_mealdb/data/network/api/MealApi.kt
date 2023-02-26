package com.bootcamp.falah_mealdb.data.network.api

import com.bootcamp.falah_mealdb.model.MealDetail
import com.bootcamp.falah_mealdb.model.ResponseMeal
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {

//    @GET("filter.php?c=Seafood")
//    fun getMeal() : Response<ResponseMeal>

//    @GET("lookup.php?i=52959")
//    fun getMeal() : Response<ResponseMeal>


//    @GET("lookup.php?i={idMeal}")
//    suspend fun getMealDetailById(
//        @Path("idMeal") gameId:Int
//    ):Response<ResponseMeal>



    @GET("filter.php")
    suspend fun getMeal(@Query("c") category : String) : Response<ResponseMeal>

    @GET("lookup.php")
    suspend fun getMealDetail(@Query("i") mealId : String) :Response<MealDetail>
}

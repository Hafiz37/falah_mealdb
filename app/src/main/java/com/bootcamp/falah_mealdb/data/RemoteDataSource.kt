package com.bootcamp.falah_mealdb.data

import android.util.Log
import com.bootcamp.falah_mealdb.data.network.api.MealApi
import com.bootcamp.falah_mealdb.data.network.handler.NetworkResult
import com.bootcamp.falah_mealdb.model.MealDetail
import com.bootcamp.falah_mealdb.model.ResponseMeal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val MealsApi: MealApi) {

    suspend fun getMeals():Flow<NetworkResult<ResponseMeal>> = flow {
        try {
            emit(NetworkResult.Loading(true))

            val meals = MealsApi.getMeal("Seafood")


//                request success
            if(meals.isSuccessful){
                val responseBody = meals.body()

//                if data empty
                if(responseBody?.meals?.isEmpty() == true){
                    emit(NetworkResult.Error("Meal list not found"))
                } else {
                    emit(NetworkResult.Success(responseBody!!))
                }
            } else {
                Log.d("Api service error", "status code ${meals.code()}, message${meals.message()} ")
                emit(NetworkResult.Error("Failed to fetch data from server"))
            }

        } catch (err: Exception){
            err.printStackTrace()
            Log.d("remoteError", "${err.message}")
            emit(NetworkResult.Error("Something went wrong. Please check log."))
        }
    }.flowOn(Dispatchers.IO)





    suspend fun getMealDetailById(mealId: String): Flow<NetworkResult<MealDetail>> = flow {
        try {
            emit(NetworkResult.Loading(true))

            val meal = MealsApi.getMealDetail(mealId)
            if (meal.isSuccessful) {
                val responseBody = meal.body()

                if (responseBody != null) {
                    emit(NetworkResult.Success(responseBody))
                } else {
                    emit(NetworkResult.Error("Can't fetch detail game."))
                }
            } else {
                // request data failed
                Log.d(
                    "apiServiceError",
                    "statusCode:${meal.code()}, message:${meal.message()}"
                )
                emit(NetworkResult.Error("Failed to fetch data from server."))
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Log.d("remoteError", "${e.message}")
            emit(NetworkResult.Error("Something went wrong. Please check log."))
        }
    }.flowOn(Dispatchers.IO)

}
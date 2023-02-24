package com.bootcamp.falah_mealdb.data

import android.util.Log
import com.bootcamp.falah_mealdb.data.metwork.api.MealApi
import com.bootcamp.falah_mealdb.data.metwork.handler.NetworkResult
import com.bootcamp.falah_mealdb.model.ResponseMeal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val mealApi: MealApi) {

    suspend fun getMeal():Flow<NetworkResult<ResponseMeal>> = flow {
        try {
            emit(NetworkResult.Loading(true))
            val meal = mealApi.getMeal()

//                request success
            if(meal.isSuccessful){
                val responseBody = meal.body()

//                if data empty
                if(responseBody?.meals?.isEmpty() == true){
                    emit(NetworkResult.Error("Meal list not found"))
                } else {
                    emit(NetworkResult.Success(responseBody!!))
                }
            } else {
                Log.d("Api service error", "status code ${meal.code()}, message${meal.message()} ")
                emit(NetworkResult.Error("Failed to fetch data from server"))
            }

        } catch (err: Exception){
            err.printStackTrace()
            Log.d("remoteError", "${err.message}")
            emit(NetworkResult.Error("Something went wrong. Please check log."))
        }
    }.flowOn(Dispatchers.IO)

}
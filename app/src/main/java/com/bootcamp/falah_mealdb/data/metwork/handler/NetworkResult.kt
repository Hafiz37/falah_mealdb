package com.bootcamp.falah_mealdb.data.metwork.handler

sealed class NetworkResult <T>(
    val data : T? = null,
    val errorMassage : String? = null,
    val isLoading : Boolean = false
){
    class Success<T>(data : T) : NetworkResult<T>(data)
    class Error<T>(errorMassage: String, data : T? = null) : NetworkResult<T>(data, errorMassage)
    class Loading<T>(isLoading: Boolean) : NetworkResult<T>(isLoading = isLoading)
}




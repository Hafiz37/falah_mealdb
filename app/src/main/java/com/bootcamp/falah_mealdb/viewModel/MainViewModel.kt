package com.bootcamp.falah_mealdb.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bootcamp.falah_mealdb.data.RemoteDataSource
import com.bootcamp.falah_mealdb.data.Repositori
import com.bootcamp.falah_mealdb.data.metwork.Service
import com.bootcamp.falah_mealdb.data.metwork.handler.NetworkResult
import com.bootcamp.falah_mealdb.model.MealsItem
import com.bootcamp.falah_mealdb.model.ResponseMeal
import kotlinx.coroutines.launch

class MainViewModel():ViewModel() {

    private val remoteService = Service.MealService
    private val remote = RemoteDataSource(remoteService)
    private val repositori = Repositori(remote)

    private var _mealList: MutableLiveData<NetworkResult<ResponseMeal>> = MutableLiveData()
    val mealList: LiveData<NetworkResult<ResponseMeal>> = _mealList

    init {
        fetchMealList()
    }

    private fun fetchMealList(){
        viewModelScope.launch {
            repositori.remote.getMeal().collect{res ->
                _mealList.value = res
            }
        }
    }

}
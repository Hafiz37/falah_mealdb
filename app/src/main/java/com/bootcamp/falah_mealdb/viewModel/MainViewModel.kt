package com.bootcamp.falah_mealdb.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bootcamp.falah_mealdb.data.RemoteDataSource
import com.bootcamp.falah_mealdb.data.Repository
import com.bootcamp.falah_mealdb.data.network.Service
import com.bootcamp.falah_mealdb.data.network.handler.NetworkResult
import com.bootcamp.falah_mealdb.model.ResponseMeal
import kotlinx.coroutines.launch

class MainViewModel():ViewModel() {

    private val remoteService = Service.mealService
    private val remote = RemoteDataSource(remoteService)
    private val repository = Repository(remote)

    private var _mealList: MutableLiveData<NetworkResult<ResponseMeal>> = MutableLiveData()
    val mealList: LiveData<NetworkResult<ResponseMeal>> = _mealList

    init {
        fetchMealList()
    }

    private fun fetchMealList(){
        viewModelScope.launch {
            repository.remote?.getMeals()?.collect{ res ->
                _mealList.value = res
            }
        }
    }

}
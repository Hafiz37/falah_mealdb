package com.bootcamp.falah_mealdb.data.database

import androidx.room.TypeConverter
import com.bootcamp.falah_mealdb.model.MealDetail
import com.bootcamp.falah_mealdb.model.MealsItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MealTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun mealDataToString(meal: MealDetail): String {
        return gson.toJson(meal)
    }

    @TypeConverter
    fun mealStringToData(string: String): MealDetail {
        val listType = object : TypeToken<MealDetail>() {}.type
        return gson.fromJson(string, listType)
    }
}
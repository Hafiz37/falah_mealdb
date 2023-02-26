package com.bootcamp.falah_mealdb.data.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MealDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeal(mealEntity: MealEntity)

    @Query("SELECT * FROM MEAL_TABLE_NAME ORDER BY id ASC")
    fun listMeal(): Flow<List<MealEntity>>

    @Delete()
    suspend fun deleteMeal(mealEntity: MealEntity)

}
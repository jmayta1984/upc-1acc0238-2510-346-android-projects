package pe.edu.upc.mealscompose.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import pe.edu.upc.mealscompose.data.model.MealEntity

@Dao
interface MealDao {

    @Insert
    suspend fun insertMeal(mealEntity: MealEntity)

    @Delete
    suspend fun deleteMeal(mealEntity: MealEntity)

    @Query("select * from meals where id =:id")
    suspend fun fetchMealById(id: String): List<MealEntity>
}
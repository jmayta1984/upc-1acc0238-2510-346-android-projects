package pe.edu.upc.mealscompose.data.model

import com.google.gson.annotations.SerializedName

data class MealsResponse(
    val meals: List<MealResponse>
)

data class MealResponse (
    @SerializedName("idMeal")
    val id: String?,
    @SerializedName("strMeal")
    val name: String?,
    @SerializedName("strMealThumb")
    val poster: String?
)
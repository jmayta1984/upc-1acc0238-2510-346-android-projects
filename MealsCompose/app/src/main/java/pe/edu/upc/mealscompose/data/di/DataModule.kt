package pe.edu.upc.mealscompose.data.di

import pe.edu.upc.mealscompose.data.remote.ApiConstants
import pe.edu.upc.mealscompose.data.remote.CategoryService
import pe.edu.upc.mealscompose.data.remote.MealService
import pe.edu.upc.mealscompose.data.repository.CategoryRepository
import pe.edu.upc.mealscompose.data.repository.MealRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataModule {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getCategoryService(): CategoryService {
        return getRetrofit().create(CategoryService::class.java)
    }

    fun getCategoryRepository(): CategoryRepository {
        return CategoryRepository(getCategoryService())
    }

    fun getMealService(): MealService {
        return getRetrofit().create(MealService::class.java)
    }

    fun getMealRepository(): MealRepository {
        return MealRepository(getMealService())
    }
}
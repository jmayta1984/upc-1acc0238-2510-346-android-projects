package pe.edu.upc.mealscompose.data.di

import pe.edu.upc.mealscompose.data.remote.ApiConstants
import pe.edu.upc.mealscompose.data.remote.CategoryService
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
}
package pe.edu.upc.mealscompose

import android.app.Application

class MealApplication: Application() {

    companion object {
        lateinit var instance: MealApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
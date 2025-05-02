package pe.edu.upc.mealscompose.presentation

import android.provider.ContactsContract
import pe.edu.upc.mealscompose.data.di.DataModule
import pe.edu.upc.mealscompose.presentation.viewmodel.CategoryListViewModel

object PresentationModule {
    fun getCategoryListViewModel(): CategoryListViewModel {
        return CategoryListViewModel(DataModule.getCategoryRepository())
    }
}
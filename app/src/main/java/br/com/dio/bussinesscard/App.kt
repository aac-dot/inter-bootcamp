package br.com.dio.bussinesscard

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.dio.bussinesscard.data.AppDatabase
import br.com.dio.bussinesscard.data.BusinessCardRepository
import br.com.dio.bussinesscard.ui.MainViewModel

class App : Application() {
    private val database by lazy {
        AppDatabase.getDatabase(this)
    }
    val repository by lazy {
        BusinessCardRepository(database.businessDao())
    }
}

class MainViewModelFactory(private val repository: BusinessCardRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown view model")
    }

}
package br.com.dio.bussinesscard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import br.com.dio.bussinesscard.data.BusinessCard
import br.com.dio.bussinesscard.data.BusinessCardRepository

class MainViewModel(private val businessCardRepository: BusinessCardRepository) : ViewModel() {
    fun insert(businessCard: BusinessCard) {
        businessCardRepository.insert(businessCard)
    }

    fun getAll() : LiveData<List<BusinessCard>> {
        return businessCardRepository.getAll()
    }
}
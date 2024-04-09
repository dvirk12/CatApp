package com.example.catapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.catapp.model.CatFact
import com.example.catapp.repository.CatRepository
import com.example.catapp.network.CatApiService

class CatViewModel : ViewModel() {
    private val catApiService = CatApiService.create() // Assume this method sets up Retrofit
    private val catRepository = CatRepository(catApiService)

    val catFacts: LiveData<List<CatFact>> = catRepository.getCatFacts()
}
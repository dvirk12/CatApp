package com.example.catapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.catapp.model.CatFact
import com.example.catapp.network.CatApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CatRepository(private val catApiService: CatApiService) {

    fun getCatFacts(): LiveData<List<CatFact>> {
        val data = MutableLiveData<List<CatFact>>()

        catApiService.getCatFacts().enqueue(object : Callback<List<CatFact>> {
            override fun onResponse(call: Call<List<CatFact>>, response: Response<List<CatFact>>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<List<CatFact>>, t: Throwable) {
                // Handle failure
            }
        })

        return data
    }
}

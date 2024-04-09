package com.example.catapp.network
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.Call
import com.example.catapp.model.CatFact

interface CatApiService {
    @GET("images/search?limit=10")
    fun getCatFacts(): Call<List<CatFact>>

    companion object {
        private const val BASE_URL = "https://api.thecatapi.com/v1/"

        fun create(): CatApiService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CatApiService::class.java)
        }
    }
}

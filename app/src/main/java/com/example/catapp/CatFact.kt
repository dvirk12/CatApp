package com.example.catapp.model

import com.example.catapp.model.CatFact
data class CatFact(
    val id: String,
    val url: String,
    val width: Int,
    val height: Int,
    val breeds: List<Breed>?
)

data class Breed(
    val id: String?,
    val name: String?,
    val temperament: String?,
    val origin: String?
)
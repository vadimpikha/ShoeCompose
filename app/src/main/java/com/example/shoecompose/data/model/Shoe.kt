package com.example.shoecompose.data.model

data class Shoe(
    val id: Int,
    val model: String,
    val brand: String,
    val description: String,
    val photos: List<String>,
    val rating: Float,
    val price: Double
)

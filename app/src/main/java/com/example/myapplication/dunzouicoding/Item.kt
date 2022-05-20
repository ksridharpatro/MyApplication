package com.example.myapplication.dunzouicoding

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("quantity")
    val quantity: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("original_price")
    val originalPrice: String,
)
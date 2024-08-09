package com.example.android_jetpack_compose_receipt_app.data.network.responses

import com.google.gson.annotations.SerializedName

data class RecipeResponse(
    @field:SerializedName("pk") val primaryKey: Int? = null,
    @field:SerializedName("title") val title: String? = null,
    @field:SerializedName("publisher") val publisher: String? = null,
    @field:SerializedName("featured_image") val featured_image: String? = null,
    @field:SerializedName("rating") val rating: Int? = null,
    @field:SerializedName("source_url") val source_url: String? = null,
    @field:SerializedName("description") val description: String? = null,
    @field:SerializedName("cooking_instructions") val cooking_instructions: String? = null,
    @field:SerializedName("ingredients") val ingredients: List<String>,
    @field:SerializedName("date_added") val date_added: String? = null,
    @field:SerializedName("date_updated") val date_updated: String? = null,
    @field:SerializedName("long_date_added") val long_date_added: Int? = null,
    @field:SerializedName("long_date_updated") val long_date_updated: Int? = null,
)
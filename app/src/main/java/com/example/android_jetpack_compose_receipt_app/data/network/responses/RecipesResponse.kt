package com.example.android_jetpack_compose_receipt_app.data.network.responses

import com.google.gson.annotations.SerializedName

data class RecipesResponse(
    @field:SerializedName("count") val count: Int? = null,
    @field:SerializedName("results") val results: List<RecipeResponse>
)
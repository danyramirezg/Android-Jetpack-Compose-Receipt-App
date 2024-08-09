package com.example.android_jetpack_compose_receipt_app.data.network.api

import com.example.android_jetpack_compose_receipt_app.data.network.responses.RecipesResponse
import com.example.android_jetpack_compose_receipt_app.data.network.responses.RecipeResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RecipeApi {
    @GET("api/recipe/get/")
    suspend fun getById(
        @Header("Authorization") token: String,
        @Query("id") id: Int
    ): RecipeResponse

    @GET("api/recipe/search/")
    suspend fun searchReceipt(
        @Header("Authorization") token: String,
        @Query("page") page: Int,
        @Query("query") query: String
    ): RecipesResponse
}
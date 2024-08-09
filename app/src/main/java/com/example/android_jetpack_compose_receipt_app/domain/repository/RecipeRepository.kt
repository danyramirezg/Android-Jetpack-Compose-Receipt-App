package com.example.android_jetpack_compose_receipt_app.domain.repository

import com.example.android_jetpack_compose_receipt_app.domain.model.Recipe

interface RecipeRepository {
    suspend fun searchRecipe(token: String, page: Int, query: String) : List <Recipe>

    suspend fun getRecipe(token: String, id: Int): Recipe
}
package com.example.android_jetpack_compose_receipt_app.data.repository

import com.example.android_jetpack_compose_receipt_app.domain.repository.RecipeRepository
import com.example.android_jetpack_compose_receipt_app.domain.model.Recipe
import com.example.android_jetpack_compose_receipt_app.data.network.RecipeDtoMapper
import com.example.android_jetpack_compose_receipt_app.data.network.api.RecipeApi

class RecipeRepositoryImpl(
    private val recipeApi: RecipeApi,
    private val mapper: RecipeDtoMapper
) : RecipeRepository {
    override suspend fun searchRecipe(token: String, page: Int, query: String): List<Recipe> {
        val result = recipeApi.searchReceipt(token, page, query).results
        return mapper.toDomainList(result)
    }

    override suspend fun getRecipe(token: String, id: Int): Recipe {
        val result = recipeApi.getById(token, id)
        return mapper.mapToDomainModel(result)
    }
}
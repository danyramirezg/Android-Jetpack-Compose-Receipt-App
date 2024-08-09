package com.example.android_jetpack_compose_receipt_app.data.network

import com.example.android_jetpack_compose_receipt_app.data.network.responses.RecipeResponse
import com.example.android_jetpack_compose_receipt_app.domain.model.Recipe

class RecipeDtoMapper : DomainMapper<RecipeResponse, Recipe> {
    override fun mapToDomainModel(model: RecipeResponse): Recipe {
        return Recipe(
            id = model.primaryKey,
            title = model.title,
            publisher = model.publisher,
            featuredImage = model.featured_image,
            rating = model.rating,
            source_url = model.source_url,
            description = model.description,
            cooking_instructions = model.cooking_instructions,
            ingredients = model.ingredients ?: listOf(),
            dateAdded = model.date_added,
            date_updated = model.date_updated
        )

    }

    override fun mapFromDomainModel(domainModel: Recipe): RecipeResponse {
        return RecipeResponse(
            primaryKey = domainModel.id,
            title = domainModel.title,
            publisher = domainModel.publisher,
            featured_image = domainModel.featuredImage,
            rating = domainModel.rating,
            source_url = domainModel.source_url,
            description = domainModel.description,
            cooking_instructions = domainModel.cooking_instructions,
            ingredients = domainModel.ingredients as List<String>,
            date_added = domainModel.dateAdded,
            date_updated = domainModel.date_updated,
            long_date_added = domainModel.long_date_added,
            long_date_updated = domainModel.long_date_updated
        )
    }

    override fun toDomainList(initial: List<RecipeResponse>): List<Recipe> {
        return initial.map {
            mapToDomainModel(it)
        }
    }

    override fun fromDomainList(initial: List<Recipe>): List<RecipeResponse> {
        return initial.map {
            mapFromDomainModel(it)
        }
    }
}
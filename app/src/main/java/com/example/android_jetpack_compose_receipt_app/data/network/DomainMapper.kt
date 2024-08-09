package com.example.android_jetpack_compose_receipt_app.data.network

import com.example.android_jetpack_compose_receipt_app.data.network.responses.RecipeResponse
import com.example.android_jetpack_compose_receipt_app.domain.model.Recipe

interface DomainMapper<T, DomainModel> {
    fun mapToDomainModel(model: T): DomainModel

    fun mapFromDomainModel(domainModel: DomainModel): T

    fun toDomainList(initial: List<RecipeResponse>): List<Recipe>

    fun fromDomainList(initial: List<Recipe>): List<RecipeResponse>
}
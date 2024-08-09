package com.example.android_jetpack_compose_receipt_app.domain.model

data class Recipe(
    val id: Int? = null,
    val title: String? = null,
    val publisher: String? = null,
    val featuredImage: String? = null,
    val rating: Int? = null,
    val source_url: String? = null,
    val description: String? = null,
    val cooking_instructions: String? = null,
    val ingredients: List<String?>,
    val dateAdded: String? = null,
    val date_updated: String? = null,
    val long_date_added: Int? = null,
    val long_date_updated: Int? = null,
)
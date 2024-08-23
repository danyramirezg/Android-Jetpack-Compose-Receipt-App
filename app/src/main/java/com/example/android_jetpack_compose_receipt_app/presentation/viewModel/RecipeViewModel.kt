package com.example.android_jetpack_compose_receipt_app.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_jetpack_compose_receipt_app.data.network.RecipeDtoMapper
import com.example.android_jetpack_compose_receipt_app.domain.model.Recipe
import com.example.android_jetpack_compose_receipt_app.domain.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val recipeDtoMapper: RecipeDtoMapper,
    private val repository: RecipeRepository,
    private val token: String
) : ViewModel() {

    private val _recipeList = MutableStateFlow<List<Recipe>>(emptyList())
    var recipeList: StateFlow<List<Recipe>> = _recipeList.asStateFlow()

    private val _recipe = MutableStateFlow<Recipe?>(null)
    var recipe: StateFlow<Recipe?> = _recipe.asStateFlow()


    fun searchRecipe() {
        viewModelScope.launch {
            val result = repository.searchRecipe(
                token = token,
                page = 1,
                query = "pasta"
            )
            _recipeList.update { result }
        }
    }

    fun getRecipeById(recipeId: String) {
        viewModelScope.launch {
            _recipe.value = repository.getRecipe(token, recipeId.toInt())
        }
    }
}
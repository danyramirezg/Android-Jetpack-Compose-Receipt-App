package com.example.android_jetpack_compose_receipt_app.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.android_jetpack_compose_receipt_app.presentation.viewModel.RecipeViewModel

@Composable
fun RecipeDetailsScreen(recipeId: String?, recipeViewModel: RecipeViewModel = hiltViewModel()) {

    val stateRecipe by recipeViewModel.recipe.collectAsState()

    LaunchedEffect(recipeId) {
        if (recipeId != null) {
            recipeViewModel.getRecipeById(recipeId)
        }
    }

    if (stateRecipe != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = stateRecipe?.title.orEmpty(),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Publisher: ${stateRecipe?.publisher.orEmpty()}",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Ingredients:",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )

            stateRecipe?.ingredients?.forEach { ingredient ->
                Text(
                    text = "- $ingredient",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }
        }
    } else {
        Text(
            text = "Recipe not found",
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(84.dp)
        )
    }
}
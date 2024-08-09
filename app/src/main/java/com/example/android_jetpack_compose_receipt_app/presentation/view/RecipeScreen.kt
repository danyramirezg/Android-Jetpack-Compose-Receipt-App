package com.example.android_jetpack_compose_receipt_app.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.android_jetpack_compose_receipt_app.R
import com.example.android_jetpack_compose_receipt_app.presentation.viewModel.RecipeViewModel


@Composable
fun RecipeScreen(
    onClick: () -> Unit,
    recipeViewModel: RecipeViewModel = hiltViewModel()
) {

    val getRecipeList = recipeViewModel::searchRecipe
    val state by recipeViewModel.recipeList.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
    ) {
        getRecipeList()
        state.forEach { recipe ->
            item {
                Column() {
                    Image(
                        // modifier = Modifier.fillMaxWidth(),
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = stringResource(id = R.string.app_name)
                    )
                    Text(
                        text = recipe.title.orEmpty(),
                        modifier = Modifier
                            .padding(50.dp),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun FilledCardExample() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
        // .size(width = 240.dp, height = 100.dp)
    ) {
        Column() {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = stringResource(id = R.string.app_name)
            )
            Text(
                text = "Recipe",
                modifier = Modifier
                    .padding(16.dp),
                textAlign = TextAlign.Center,
            )
        }
    }
}
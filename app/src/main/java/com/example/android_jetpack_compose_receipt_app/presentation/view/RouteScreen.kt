package com.example.android_jetpack_compose_receipt_app.presentation.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun RouteScreen(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "recipeScreen") {
        composable("recipeScreen") {
            RecipeScreen(
                onClick = { recipeId ->
                    navController.navigate("recipeDetails/$recipeId")
                }
            )
        }
        composable(
            "recipeDetails/{recipeId}",
            arguments = listOf(navArgument("recipeId") { type = NavType.StringType })
        ) { backStackEntry ->
            val recipeId = backStackEntry.arguments?.getString("recipeId")
            RecipeDetailsScreen(recipeId)
        }
    }
}
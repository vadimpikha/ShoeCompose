package com.example.shoecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.example.shoecompose.data.model.Sneaker
import com.example.shoecompose.ui.details.ShoeDetailsScreen
import com.example.shoecompose.ui.list.ShoeListScreen
import com.example.shoecompose.ui.theme.ShoeComposeTheme
import com.google.accompanist.insets.ProvideWindowInsets
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {

    private val sneakers by lazy {
        resources.openRawResource(R.raw.sneakers).reader().use {
            val jsonString = it.readText()
            Json.decodeFromString<List<Sneaker>>(jsonString)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ShoeComposeTheme {
                ProvideWindowInsets {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "sneakers_list") {
                        composable("sneakers_list") {
                            ShoeListScreen(sneakers = sneakers, onOpenDetails = {
                                navController.navigate("sneakers_details/${it.id}")
                            })
                        }
                        composable(
                            "sneakers_details/{sneakerId}",
                            arguments = listOf(
                                navArgument("sneakerId") { type = NavType.IntType }
                            )
                        ) {
                            val id = it.arguments?.getInt("sneakerId") ?: 0
                            ShoeDetailsScreen(
                                sneaker = sneakers.single { it.id == id },
                                onBackPressed = { navController.popBackStack() }
                            )
                        }
                    }
                }
            }
        }
    }
}
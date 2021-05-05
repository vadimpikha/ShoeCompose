package com.example.shoecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.shoecompose.data.model.Shoe
import com.example.shoecompose.ui.details.ShoeDetailsScreen
import com.example.shoecompose.ui.theme.ShoeComposeTheme
import com.google.accompanist.insets.ProvideWindowInsets

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ShoeComposeTheme {
                ProvideWindowInsets {
                    ShoeDetailsScreen(shoe = shoe)
                }
            }
        }
    }
}

private val shoe = Shoe(
    id = 0,
    model = "Air Max 95",
    brand = "Nike",
    description = "In the early ’90s Nike Basketball was dominating the sneaker market, with the popularity of basketball shoes gaining traction well ahead of runners. Lozano positioned the revolutionary Air Max 95 project as a means to recapture the public’s attention towards the performance running category.",
    photos = listOf(
        "https://static.nike.com/a/images/t_default/c28c3547-376f-410b-be2f-68dfd0e1c495/air-max-95-recraft-older-shoe-M0CClX.png",
        "https://static.nike.com/a/images/t_default/c28c3547-376f-410b-be2f-68dfd0e1c495/air-max-95-recraft-older-shoe-M0CClX.png",
    ),
    rating = 5.0f,
    price = 170.0
)
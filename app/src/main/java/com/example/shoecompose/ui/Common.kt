package com.example.shoecompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

@Composable
fun IconButton(
    painter: Painter,
    onClick: () -> Unit
) {
    Button(
        onClick,
        modifier = Modifier.background(Color.White, CircleShape)
    ) {
        Image(painter = painter, contentDescription = null)
    }
}
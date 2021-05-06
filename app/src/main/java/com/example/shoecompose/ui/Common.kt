package com.example.shoecompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.shoecompose.R
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun FavoriteToggle(
    isFavorite: Boolean,
    onFavoriteChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    IconToggleButton(
        checked = isFavorite,
        onCheckedChange = onFavoriteChanged,
        modifier = modifier
            .background(
                if (isFavorite) MaterialTheme.colors.secondary else Color.White,
                CircleShape
            )
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_favorite_24),
            contentDescription = "Back",
            tint = if (isFavorite) MaterialTheme.colors.onSecondary else Color.Gray
        )
    }
}


@Composable
fun SneakersImage(image: String, modifier: Modifier = Modifier) {
    Image(
        painter = rememberCoilPainter(image),
        contentDescription = null,
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        contentScale = ContentScale.Crop
    )
}
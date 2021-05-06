package com.example.shoecompose.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.shoecompose.R
import com.example.shoecompose.data.model.Sneaker
import com.example.shoecompose.ui.FavoriteToggle
import com.example.shoecompose.ui.SneakersImage
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ShoeDetailsScreen(
    sneaker: Sneaker,
    onBackPressed: () -> Unit
) {

    var shoeLiked by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            DetailsTopBar(
                title = "Men's shoe",
                onBackPressed = onBackPressed,
                shoeLiked = shoeLiked,
                onShoeLikeChanged = { shoeLiked = it },
                modifier = Modifier
                    .padding(24.dp)
                    .statusBarsPadding()
            )
        }, bottomBar = {
            DetailsBottomSheet(
                modelName = "",
                price = "",
                rating = "",
                description = sneaker.details,
            )
        },
        backgroundColor = Color(0xFFE9E9E9)
    ) {
        SneakersImage(
            image = sneaker.mainPictureUrl,
            modifier = Modifier
                .padding(32.dp)
        )
    }

}

@Composable
fun DetailsBottomSheet(
    modelName: String,
    price: String,
    rating: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .navigationBarsPadding()
        ) {
            Row(
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = modelName,
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = price,
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Medium
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_star_24),
                    contentDescription = null,
                    tint = Color(0xFFFFC107)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = rating,
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.Medium
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = description)
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                contentPadding = PaddingValues(16.dp),
                shape = CircleShape
            ) {
                Text(
                    text = "Add to Bag",
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun DetailsTopBar(
    title: String,
    onBackPressed: () -> Unit,
    shoeLiked: Boolean,
    onShoeLikeChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        IconButton(
            onClick = onBackPressed,
            modifier = Modifier.background(
                Color.White,
                CircleShape
            )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_arrow_back_ios_new_24),
                contentDescription = "Back",
                tint = Color.Gray
            )
        }

        Text(
            text = title,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold
        )

        FavoriteToggle(
            isFavorite = shoeLiked,
            onFavoriteChanged = onShoeLikeChanged
        )
    }
}
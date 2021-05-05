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
import coil.request.ImageRequest
import com.example.shoecompose.R
import com.example.shoecompose.data.model.Shoe
import com.google.accompanist.coil.CoilImage
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ShoeDetailsScreen(shoe: Shoe) {

    var shoeLiked by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE9E9E9))
    ) {
        ShoePhotos(shoe.photos)

        DetailsTopBar(
            title = "Men's shoe",
            onBackPressed = {},
            shoeLiked = shoeLiked,
            onShoeLikeChanged = { shoeLiked = it },
            modifier = Modifier
                .padding(24.dp)
                .statusBarsPadding()
        )

        DetailsBottomSheet(
            modelName = "${shoe.brand} ${shoe.model}",
            price = "\$${shoe.price}",
            rating = "${shoe.rating}",
            description = shoe.description,
            Modifier.align(Alignment.BottomCenter)
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
            .fillMaxWidth()
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

@ExperimentalPagerApi
@Composable
fun ShoePhotos(photos: List<String>) {
    val pagerState = rememberPagerState(pageCount = photos.size)
    Box {
        HorizontalPager(state = pagerState) { page ->
            val painter = rememberCoilPainter(
                request = photos[page]
            )
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )
        }
        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
        )
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

        IconToggleButton(
            checked = shoeLiked,
            onCheckedChange = onShoeLikeChanged,
            modifier = Modifier.background(
                if (shoeLiked) MaterialTheme.colors.secondary else Color.White,
                CircleShape
            )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_favorite_24),
                contentDescription = "Back",
                tint = if (shoeLiked) MaterialTheme.colors.onSecondary else Color.Gray
            )
        }
    }
}
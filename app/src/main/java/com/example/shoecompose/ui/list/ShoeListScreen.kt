package com.example.shoecompose.ui.list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoecompose.data.model.Sneaker
import com.example.shoecompose.ui.SneakersImage
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.toPaddingValues

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShoeListScreen(
    sneakers: List<Sneaker>,
    onOpenDetails: (Sneaker) -> Unit
) {

    Scaffold(
        backgroundColor = Color(0xFFE9E9E9)
    ) { paddingValues ->

        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            modifier = Modifier
                .padding(paddingValues),
            contentPadding = LocalWindowInsets.current.statusBars.toPaddingValues(
                additionalHorizontal = 24.dp,
                additionalVertical = 24.dp
            )
        ) {
            itemsIndexed(sneakers) { index, item ->
                SneakerPreviewCard(
                    item,
                    Modifier
                        .aspectRatio(.7f)
                        .padding(
                            start = 8.dp.takeIf { index % 2 == 1 } ?: 0.dp,
                            end = 8.dp.takeIf { index % 2 == 0 } ?: 0.dp,
                            bottom = 16.dp
                        ),
                    onClick = {
                        onOpenDetails(item)
                    }
                )
            }
        }

    }

}

@Composable
fun SneakerPreviewCard(sneaker: Sneaker, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(modifier = modifier) {
        Card {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(onClick = onClick)
            ) {
                Column {
                    SneakersImage(
                        image = sneaker.gridPictureUrl,
                        modifier = Modifier
                            .weight(.65f)
                    )
                    Spacer(modifier = Modifier.weight(.35f))
                }
                Column {
                    Spacer(modifier = Modifier.weight(.4f))
                    Column(
                        modifier = Modifier
                            .padding(12.dp)
                            .weight(.6f),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Text(
                            text = sneaker.name,
                            maxLines = 2,
                            style = MaterialTheme.typography.subtitle1,
                            fontWeight = FontWeight.Medium
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = sneaker.gender.joinToString("|"),
                            style = MaterialTheme.typography.subtitle2
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Row {
                            Text(
                                text = formatPrice(sneaker.retailPriceCents),
                                style = MaterialTheme.typography.h6,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

fun formatPrice(cents: Int?): String {
    if (cents == null) return "\$???"
    return "\$${cents / 100}"
}

package com.example.androiddevchallenge.ui.home.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.components.DrawableResImage
import com.example.androiddevchallenge.ui.theme.DevChallengeTheme

private val RowItemSize = 136.dp

@Composable
fun CardRows(modifier: Modifier = Modifier) {
    LazyRow(
        horizontalArrangement = spacedBy(8.dp),
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
        content = {
            items(3) {
                Card(
                    modifier = Modifier.height(RowItemSize),
                    shape = RoundedCornerShape(4.dp),
                    elevation = 1.dp,
                    backgroundColor = DevChallengeTheme.colors.textBody1,
                ) {
                    Column(
                        modifier = Modifier.background(DevChallengeTheme.colors.onSecondary),
                        horizontalAlignment = CenterHorizontally,
                    ) {
                        DrawableResImage(
                            modifier = Modifier.requiredWidth(RowItemSize),
                            drawableRes = R.drawable.desert_chic,
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
//                            .background(Color.Red),
                        ) {
                            Text(
                                modifier = Modifier
//                                .background(Color.Blue)
                                    .align(Alignment.Center),
                                text = "test",
                                style = DevChallengeTheme.typography.h2,
                                color = DevChallengeTheme.colors.textH2,
                            )
                        }
                    }
                }
            }
        }
    )
}
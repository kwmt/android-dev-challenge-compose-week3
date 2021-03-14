/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.home.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.components.DrawableResImage
import com.example.androiddevchallenge.ui.home.LocalCompositionViewModel
import com.example.androiddevchallenge.ui.theme.DevChallengeTheme

private val RowItemSize = 136.dp
val ElevationPaddingSize = 8.dp

@Composable
fun CardRows(modifier: Modifier = Modifier) {
    val viewModel = LocalCompositionViewModel.current
    LazyRow(
        modifier = modifier,
        horizontalArrangement = spacedBy(8.dp),
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
        content = {
            items(viewModel.themes) { theme ->
                Card(
                    modifier = Modifier
                        .height(RowItemSize + ElevationPaddingSize)
                        .padding(bottom = ElevationPaddingSize),
                    shape = RoundedCornerShape(4.dp),
                    elevation = 4.dp,
                    backgroundColor = DevChallengeTheme.colors.textBody1,
                ) {
                    Column(
                        modifier = Modifier
                            .background(DevChallengeTheme.colors.onSecondary),
                        verticalArrangement = Arrangement.Center,
                    ) {
                        DrawableResImage(
                            modifier = Modifier.requiredWidth(RowItemSize),
                            drawableRes = theme.drawableRes,
                        )

                        Box(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Text(
                                modifier = Modifier
//                                    .background(Color.Blue)
                                    .align(Alignment.CenterStart)
                                    .padding(horizontal = 16.dp),
                                textAlign = TextAlign.Start,
                                text = theme.name,
                                style = DevChallengeTheme.typography.h2.copy(letterSpacing = 0.sp),
                                color = DevChallengeTheme.colors.textH2,
                                maxLines = 1,
                            )
                        }
                    }
                }
            }
        }
    )
}

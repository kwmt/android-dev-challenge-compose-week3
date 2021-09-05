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
package com.example.androiddevchallenge.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.androiddevchallenge.ui.theme.DevChallengeTheme

@Composable
fun NetworkImage(
    modifier: Modifier = Modifier,
    url: String,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Crop,
    placeholderColor: Color? = DevChallengeTheme.colors.onSecondary
) {
//    Image(
//        data = url,
//        modifier = modifier.aspectRatio(17f / 12f),
//        contentDescription = contentDescription,
//        contentScale = contentScale,
//        loading = {
//            if (placeholderColor != null) {
//                Spacer(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(placeholderColor)
//                )
//            }
//        }
//    )
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun DrawableResImage(
    modifier: Modifier = Modifier,
    @DrawableRes drawableRes: Int,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Crop,
    placeholderColor: Color? = DevChallengeTheme.colors.onSecondary
) {
    // Advanced
    Image(
        painter = rememberImagePainter(
            data = drawableRes,
            builder = {
                transformations(CircleCropTransformation())
            }
        ),
        contentScale = contentScale,
        contentDescription = contentDescription,
        modifier = modifier
    )
}

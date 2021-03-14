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
package com.example.androiddevchallenge.ui.home

import androidx.annotation.DrawableRes
import androidx.compose.runtime.compositionLocalOf
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.home.HomeViewModel.Companion.DESCRIPTION

val LocalCompositionViewModel = compositionLocalOf<HomeViewModel> {
    error("ViewModelが提供されていません")
}

data class Theme(
    val name: String,
    @DrawableRes val drawableRes: Int
)

data class Garden(
    val name: String,
    val description: String = DESCRIPTION,
    @DrawableRes val drawableRes: Int,
)

class HomeViewModel : ViewModel() {
    val themes: List<Theme> = listOf(
        Theme(
            name = "Desert chick",
            drawableRes = R.drawable.desert_chic
        ),
        Theme(
            name = "Tiny terrariums",
            drawableRes = R.drawable.tiny_terrariums
        ),
        Theme(
            name = "Jungle vibes",
            drawableRes = R.drawable.jungle_vibes
        ),
        Theme(
            name = "Easy care",
            drawableRes = R.drawable.easy_care
        ),
        Theme(
            name = "Statements",
            drawableRes = R.drawable.statements
        ),
    )
    val gardens: List<Garden> = listOf(
        Garden(
            name = "Monstera",
            drawableRes = R.drawable.monstera
        ),
        Garden(
            name = "Aglaonema",
            drawableRes = R.drawable.aglaonema
        ),
        Garden(
            name = "Peace lily",
            drawableRes = R.drawable.peace_lily
        ),
        Garden(
            name = "Fiddie leaf tree",
            drawableRes = R.drawable.fiddie_leaf
        ),
        Garden(
            name = "Snake plant",
            drawableRes = R.drawable.snake_plant
        ),
        Garden(
            name = "Photos",
            drawableRes = R.drawable.photos
        ),
    )

    companion object {
        const val DESCRIPTION = "This is a description"
    }
}

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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.ui.components.search.Search
import com.example.androiddevchallenge.ui.home.views.CardRows
import com.example.androiddevchallenge.ui.home.views.ElevationPaddingSize
import com.example.androiddevchallenge.ui.home.views.ImageList
import com.example.androiddevchallenge.ui.theme.DevChallengeScaffold
import com.example.androiddevchallenge.ui.theme.DevChallengeTheme

@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel()) {
    CompositionLocalProvider(LocalCompositionViewModel provides viewModel) {
        HomeScreenImpl()
    }
}

@Composable
fun HomeScreenImpl() {
    Column(modifier = Modifier.padding(top = 40.dp, bottom = 56.dp)) {
        val modifier = Modifier.padding(horizontal = 16.dp)
        Search(modifier = modifier)
        HomeTitle(modifier = modifier, text = "Browse themes", 32.dp)
        CardRows(modifier = Modifier.padding(top = 16.dp))
        HomeTitle(
            modifier = modifier,
            text = "Design your home garden",
            40.dp - ElevationPaddingSize,
            isFilterIcon = true
        )
        ImageList()
    }
}

@Composable
private fun HomeTitle(
    modifier: Modifier = Modifier,
    text: String,
    before: Dp,
    isFilterIcon: Boolean = false
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            modifier = Modifier
                .paddingFrom(alignmentLine = LastBaseline, before = before),
            text = text,
            style = DevChallengeTheme.typography.h1,
            color = DevChallengeTheme.colors.textH1
        )
        if (isFilterIcon) {
            Icon(
                Icons.Filled.FilterList, contentDescription = null,
                tint = DevChallengeTheme.colors.textBody1,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.Bottom)
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    DevChallengeScaffold {
        HomeScreen(HomeViewModel())
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    DevChallengeScaffold(darkTheme = true) {
        HomeScreen(HomeViewModel())
    }
}

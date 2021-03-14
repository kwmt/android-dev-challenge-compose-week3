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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.components.DrawableResImage
import com.example.androiddevchallenge.ui.home.Garden
import com.example.androiddevchallenge.ui.home.LocalCompositionViewModel
import com.example.androiddevchallenge.ui.theme.DevChallengeTheme

@Composable
fun ImageList(modifier: Modifier = Modifier) {
    val viewModel = LocalCompositionViewModel.current
    LazyColumn(
        modifier = modifier.padding(top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            items(viewModel.gardens) { garden ->
                GardenListItem(garden)
            }
        }
    )
}

@Composable
private fun GardenListItem(garden: Garden) {
    var checkedState by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
//            .background(Color.Red),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .height(64.dp)
        ) {
            DrawableResImage(
                modifier = Modifier
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(4.dp)),
                drawableRes = garden.drawableRes
            )
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(
                    garden.name, modifier = Modifier.paddingFromBaseline(top = 24.dp),
                    style = DevChallengeTheme.typography.h2.copy(letterSpacing = 0.sp),
                    color = DevChallengeTheme.colors.textH2
                )
                Text(
                    garden.description, modifier = Modifier.paddingFromBaseline(bottom = 24.dp),
                    style = DevChallengeTheme.typography.body1,
                    color = DevChallengeTheme.colors.textBody1
                )
            }
        }
        Checkbox(
            checked = checkedState, onCheckedChange = { checkedState = it },
            modifier = Modifier.align(Alignment.CenterVertically),
            colors = CheckboxDefaults.colors(
                uncheckedColor = DevChallengeTheme.colors.secondary,
                checkedColor = DevChallengeTheme.colors.secondary,
                checkmarkColor = DevChallengeTheme.colors.onSecondary,
            )
        )
    }
}

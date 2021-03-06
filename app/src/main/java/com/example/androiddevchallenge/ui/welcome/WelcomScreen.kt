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
package com.example.androiddevchallenge.ui.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.components.StyledButton
import com.example.androiddevchallenge.ui.theme.DevChallengeScaffold
import com.example.androiddevchallenge.ui.theme.DevChallengeTheme

@Composable
fun WelcomeScreen(onClickLogInButton: () -> Unit) {
    DevChallengeScaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painterResource(id = R.drawable.welcome_bg),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.align(Alignment.TopStart)
            )

            Column(
                modifier = Modifier.padding(top = 72.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.welcome_illos),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .offset(x = 88.dp)
                )
                Column(
                    modifier = Modifier
                        .padding(top = 48.dp)
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
//                    .background(color = MaterialTheme.colors.background),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = null,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                    Text(
                        "Beautiful home garden solutions",
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .paddingFromBaseline(bottom = 32.dp),
                        color = DevChallengeTheme.colors.textSubtitle1,
                        style = MaterialTheme.typography.subtitle1
                    )

                    StyledButton(
                        "Create account",
                        modifier = Modifier
                            .paddingFromBaseline(top = 40.dp)
                            .padding(horizontal = 16.dp)
                    ) {
                        // TODO
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    TextButton(
                        onClick = onClickLogInButton,
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Transparent,
                            contentColor = DevChallengeTheme.colors.textButton2
                        ),
                    ) {
                        Text(
                            "Log in",
                            style = MaterialTheme.typography.button
                        )
                    }
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    DevChallengeScaffold {
        WelcomeScreen {}
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    DevChallengeScaffold(darkTheme = true) {
        WelcomeScreen {}
    }
}

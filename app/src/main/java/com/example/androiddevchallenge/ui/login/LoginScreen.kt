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
package com.example.androiddevchallenge.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.ContentAlpha
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TextFieldDefaults.outlinedTextFieldColors
import androidx.compose.material.TextFieldDefaults.textFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.components.StyledButton
import com.example.androiddevchallenge.ui.theme.DevChallengeColors
import com.example.androiddevchallenge.ui.theme.DevChallengeScaffold
import com.example.androiddevchallenge.ui.theme.DevChallengeTheme
import com.example.androiddevchallenge.ui.theme.surfaceColorBackground

@Composable
fun LoginScreen(onClickLoginButton: () -> Unit) {
    DevChallengeScaffold(surfaceColor = { surfaceColorBackground() }) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                "Log in with email",
                modifier = Modifier
                    .paddingFromBaseline(184.dp),
                style = DevChallengeTheme.typography.h1,
                color = DevChallengeTheme.colors.textH1,
            )
            Spacer(modifier = Modifier.padding(top = 16.dp))
            OutlinedTextField(
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth(),
                value = "", onValueChange = { /*TODO*/ },
                placeholder = {
                    Text(
                        text = "Email address",
                        style = DevChallengeTheme.typography.body1,
                        color = DevChallengeTheme.colors.textBody1,
                    )
                },
                colors = outlinedTextFieldColors(
                    cursorColor = DevChallengeTheme.colors.textBody1,
                    focusedBorderColor = DevChallengeTheme.colors.textBody1.copy(alpha = ContentAlpha.high),
                    unfocusedBorderColor = DevChallengeTheme.colors.textBody1,
                ),
                singleLine = true,
            )
            Spacer(modifier = Modifier.requiredHeight(8.dp))
            OutlinedTextField(
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth(),
                value = "", onValueChange = { /*TODO*/ },
                placeholder = {
                    Text(
                        text = "Password (8+ characters)",
                        style = DevChallengeTheme.typography.body1,
                        color = DevChallengeTheme.colors.textBody1,
                    )
                },
                colors = outlinedTextFieldColors(
                    cursorColor = DevChallengeTheme.colors.textBody1,
                    focusedBorderColor = DevChallengeTheme.colors.textBody1.copy(alpha = ContentAlpha.high),
                    unfocusedBorderColor = DevChallengeTheme.colors.textBody1,
                ),
                singleLine = true,
            )

            val a = buildString {

            }
            Text(
                "By clicking below, you agree to our Terms of Use and consent to our Privacy Policy.",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .paddingFrom(FirstBaseline, before = 24.dp),
                textAlign = TextAlign.Center,
                style = DevChallengeTheme.typography.body2,
                color = DevChallengeTheme.colors.textBody2
            )

            Spacer(modifier = Modifier.height(16.dp))
            StyledButton(
                text = "Log in", onClick = onClickLoginButton,
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    DevChallengeScaffold(surfaceColor = { surfaceColorBackground() }) {
        LoginScreen {}
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    DevChallengeScaffold(
        darkTheme = true,
        surfaceColor = { surfaceColorBackground() }
    ) {
        LoginScreen {}
    }
}

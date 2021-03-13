package com.example.androiddevchallenge.ui.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.DevChallengeScaffold
import com.example.androiddevchallenge.ui.theme.DevChallengeTheme
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun WelcomeScreen() {
    Box(
        modifier = Modifier
//            .background(color = MaterialTheme.colors.background)
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
                Button(
                    onClick = { /*TODO*/ },
                    shape = MaterialTheme.shapes.medium.copy(
                        all = CornerSize(24.dp),
                    ),
                    modifier = Modifier
                        .height(48.dp)
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = DevChallengeTheme.colors.secondary,
                        contentColor = DevChallengeTheme.colors.textButton1
                    ),
                ) {
                    Text(
                        "Create account",
                        style = MaterialTheme.typography.button
                    )
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    DevChallengeScaffold {
        WelcomeScreen()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    DevChallengeScaffold(darkTheme = true) {
        WelcomeScreen()
    }
}

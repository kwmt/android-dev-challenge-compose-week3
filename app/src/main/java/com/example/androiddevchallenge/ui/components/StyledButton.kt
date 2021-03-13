package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.DevChallengeTheme

@Composable
fun StyledButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
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
            text,
            style = MaterialTheme.typography.button
        )
    }
}
package com.example.androiddevchallenge.ui.home.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ImageList(modifier: Modifier) {
    LazyColumn(content = {
        items(3) {
            Column() {
                Text("test")
            }
        }
    }
    )
}
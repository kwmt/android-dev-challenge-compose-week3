package com.example.androiddevchallenge.ui.components.search

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.DevChallengeScaffold
import com.example.androiddevchallenge.ui.theme.DevChallengeTheme

@Composable
fun Search() {
    SearchBar(modifier = Modifier.padding(horizontal = 16.dp))
}

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    SearchTextField(
        modifier = modifier,
        placeHolder = { SearchHint() }
    )
}

@Composable
fun SearchHint() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            modifier = Modifier.size(18.dp),
            imageVector = Icons.Outlined.Search,
            contentDescription = null,
            tint = DevChallengeTheme.colors.textBody1,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Search",
            style = DevChallengeTheme.typography.body1,
            color = DevChallengeTheme.colors.textBody1
        )
    }
}

@Composable
fun SearchTextField(
    modifier: Modifier = Modifier,
    placeHolder: @Composable () -> Unit
) {
    OutlinedTextField(
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth(),
        value = "", onValueChange = { /*TODO*/ },
        placeholder = placeHolder,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = DevChallengeTheme.colors.textBody1,
            focusedBorderColor = DevChallengeTheme.colors.textBody1.copy(alpha = ContentAlpha.high),
            unfocusedBorderColor = DevChallengeTheme.colors.textBody1,
        ),
        singleLine = true,
    )
}

@Composable
@Preview
fun PreviewSearch() {
    DevChallengeScaffold {
        Search()
    }
}

@Composable
@Preview
fun DarkPreviewSearch() {
    DevChallengeScaffold(darkTheme = true) {
        Search()
    }
}
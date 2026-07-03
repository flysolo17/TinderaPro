package com.potatolabs.tinderapro.common.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle


@Composable
fun TextLogo(modifier: Modifier = Modifier) {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colorScheme.onBackground
                )
            ) {
                append("Tindera ")
            }

            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colorScheme.primary
                )
            ) {
                append("Pro")
            }
        },
        style = MaterialTheme.typography.headlineLarge.copy(
            fontWeight = FontWeight.Bold
        )
    )
}
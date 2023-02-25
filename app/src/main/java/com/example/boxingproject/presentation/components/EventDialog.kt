package com.example.boxingproject.presentation.components

import androidx.annotation.StringRes
import androidx.compose.compiler.plugins.kotlin.ComposeErrorMessages
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun EvenDialog(
    modifier: Modifier = Modifier,
    onDismiss : (()->Unit) ? = null,
    @StringRes errorMessages: Int
){
    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        title = { Text(text = "") },
        text = { Text(text = "") },
        buttons = {

        }
    )
}
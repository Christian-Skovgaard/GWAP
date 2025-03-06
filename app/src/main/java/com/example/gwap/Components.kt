package com.example.gwap

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun InputField () {
    Column() {
        Text(text="text")
        var text by remember {mutableStateOf(TextFieldValue(""))}
        TextField(
            value = text,
            onValueChange = {newText -> text = newText},
            modifier = Modifier.background(color = Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = Color.White)
        )
    }
}
package com.example.gwap

import android.graphics.drawable.GradientDrawable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview

//@Preview(showBackground = true)
@Composable
fun SimpleTextField() {
    Box() {
        Text("text")
        var text by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = text,
            onValueChange = {newText -> text = newText}

        )
    }
}


//funktion der laver knapper - man skal kalde den med teksten til knappen
@Composable
fun addButton (buttonMessage: String): Unit {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E8B57))
    ) {
        Text(text = buttonMessage, color = Color.White)

    }
}


@Composable
fun BackgroundGradient() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient( //ide fra chatGPT
                    colors = listOf(Color(0xFFA8E6CF), Color(0xFFD291BC)),
                    start = Offset(0f, 0f),
                    end = Offset(0f, 1000f)
                )
            )
    )
}



//preview
@Preview(showBackground = true)
@Composable
fun PreviewSimpleScreen() {
        BackgroundGradient()
        addButton("Start")
    }


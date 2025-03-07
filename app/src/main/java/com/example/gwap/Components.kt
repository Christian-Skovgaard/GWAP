package com.example.gwap

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun InputField (fieldText: String) {
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Text(
            text=fieldText,
            modifier = Modifier.padding(bottom = 5.dp),
            color = Color(android.graphics.Color.parseColor("#D0D0D0"))
        )
        var text by remember {mutableStateOf(TextFieldValue(""))}
        BasicTextField (
            value = text,
            onValueChange = {newText -> text = newText},
            modifier = Modifier
                .border(width = 2.dp, color = Color(android.graphics.Color.parseColor("#D0D0D0")), RoundedCornerShape(3.dp))
                .fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TitleText (titleText:String) {
    Text(
        text = "Opret Profil",
        fontSize = 40.sp,
        modifier = Modifier.padding(10.dp)
    )
}


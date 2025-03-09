package com.example.gwap

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
            color = Color(android.graphics.Color.parseColor("#D0D0D0")),
            fontSize = 17.sp
        )
        var text by remember {mutableStateOf(TextFieldValue(""))}
        BasicTextField (
            value = text,
            onValueChange = {newText -> text = newText},
            modifier = Modifier
                .border(width = 2.dp, color = Color(android.graphics.Color.parseColor("#D0D0D0")), RoundedCornerShape(3.dp))
                .height(30.dp)
                .fillMaxWidth()

        )
    }
}

//@Preview(showBackground = true)
@Composable
fun TitleText (titleText:String) {
    Column {
        Text(
            text = titleText,
            fontSize = 30.sp,
            modifier = Modifier.padding(10.dp)
        )
        HorizontalDivider(
            color = Color(android.graphics.Color.parseColor("#D0D0D0")),
            thickness = 5.dp,
            modifier = Modifier
                .padding(bottom = 5.dp)
                .clip(RoundedCornerShape(4.dp))


        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreenButton () {
    Button(
        onClick = {}
    ) {
        Text(
            text = "Næste"
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun BackgroundBox (content: @Composable () -> Unit) {
    Box (
        modifier = Modifier.fillMaxSize()
    ) {
        Box (
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.65f)
                .background(color = Color(android.graphics.Color.parseColor("#FFFFFF")))
                .align(alignment = Alignment.Center)
                .border(
                    width = 13.dp,
                    color = Color(android.graphics.Color.parseColor("#A37AFA")),
                    shape = RoundedCornerShape(16.dp)
                    )
        ) {
            Column (
                modifier = Modifier
                    .padding(50.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                content()
            }
        }
    }
}


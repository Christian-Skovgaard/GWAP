package com.example.gwap

import android.R.id
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun Navbar(){
    Row (
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 60.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text(text = "Byt", fontSize = 20.sp, color = Color.White)
        Text(text = "Brug", fontSize = 20.sp, color = Color.White)
        Text(text = "Bevar", fontSize = 20.sp, color = Color.White)
    }
}



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
                .border(
                    width = 2.dp,
                    color = Color(android.graphics.Color.parseColor("#D0D0D0")),
                    RoundedCornerShape(3.dp)
                )
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
                .padding(horizontal = 10.dp)
                .clip(RoundedCornerShape(4.dp))
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun PurpleSlider (minValue:  Float, maxValue: Float) {
    var sliderValue by remember { mutableStateOf(0f)}
    Box () {
        Slider (
            value = sliderValue,
            onValueChange = {sliderValue = it},
            valueRange = minValue..maxValue,//value kan ændres så vi kan begrænse hvilke skostr man kan vælge
            colors = SliderDefaults.colors(
                activeTrackColor = Color(0xffA37AFA),
                inactiveTrackColor = Color(0xffA37AFA)
            ),
            thumb = {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFFD0D0D0)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = sliderValue.toInt().toString(),
                        fontSize = 20.sp,
                    )
                }
            }
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun GreenButton (text:String, navController: NavController, destination:String) {
    Button(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(0.6f)
            .aspectRatio(2.5f),
        onClick = {navController.navigate(destination)},
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF50BE80))
    ) {
        Text(
            text = text,
            fontSize = 22.sp
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
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Column (
                modifier = Modifier
                    .padding(40.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ){
                content()
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun Background () {
    Box (
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.backgoundimage),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
    }
}


@Composable
fun SizeBox(size: String, isSelected: Boolean, onClick:() -> Unit ) {
    Card(
        modifier = Modifier
            .size(34.dp)
            .clickable {},
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(7.dp)
                )
                //ændre farven til grå hvis valgt (lige nu bestemmer er de blot sat ind som uvaglte så denne linje gør ikke noget lige nu)
                .background(if (isSelected) Color.Gray else Color.White)
        ){
            Text(
                text = size,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Composable
fun SizeBoxesOnPage() {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        //laver en kasse til alle str
        val sizeList = listOf("XXS", "XS", "S", "M", "L", "XL", "XXL")

        items(sizeList){ size ->
            SizeBox(size, false, {})
        }
    }
}

//her ville man gå i gang med at lave billederne til profilview men nej
@Composable
fun ProfileGalleryPicture(img: Unit, onClick:() -> Unit) {
    val listOfImgages = listOf("")

            Card(
            modifier = Modifier
                .size(66.dp)
                .clickable {}
        ) {

          }
}

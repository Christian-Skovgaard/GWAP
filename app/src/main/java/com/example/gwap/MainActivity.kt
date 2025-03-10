package com.example.gwap

import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gwap.ui.theme.GwapTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavComponent()
        }
    }
}

@Composable
fun NavComponent () {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "StartScreen", builder = {
        composable("StartScreen") {StartScreen(navController)}
        composable("CreateProfile1") {CreateProfile1(navController)}
        composable("CreateProfile2") {CreateProfile2(navController)}
        composable("CreateProfile3") {CreateProfile3(navController)}
        composable("ProfileView") { ProfileView(navController) }
    })
}


@Composable
fun StartScreen (navController: NavController) {
    Background()
    Box (
        modifier = Modifier
            //.background(color= Color.Red)
            .fillMaxSize()
        ,
        contentAlignment = Alignment.Center
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Box () {
                Text(
                    text="Gwap",
                    fontSize = 100.sp,
                    color = Color.White
                )
            }
            Box {
                Column {
                    Button(
                        onClick = {navController.navigate("CreateProfile1")},
                        modifier = Modifier.fillMaxWidth(0.8f)
                    ) {
                        Text(text="Opret Profil")
                    }
                    Button(
                        onClick = {},
                        modifier = Modifier.fillMaxWidth(0.8f)
                    ) {
                        Text(text="Log In")
                    }
                }
            }
        }
       Navbar()
    }
}

//@Preview(showBackground = true)
@Composable
fun CreateProfile1 (navController: NavController) {
    Background()
    BackgroundBox {
        TitleText("Lav din profil")
        InputField("Fulde navn *")
        InputField("Brugernavn *")
        InputField("Email *")
        GreenButton("Næste",navController, "CreateProfile2")
    }
}

@Composable
fun CreateProfile2 (navController: NavController) {
    Background()
    BackgroundBox {
        TitleText("Find tøj der passer DIG")
        SizeBoxesOnPage()

        Text(text ="Så viser vi kun tøj du kan passe;)")
        TitleText("Hvad er din skostørrelse?")
        PurpleSlider(35F, 48F)
        GreenButton("Næste",navController, "CreateProfile3")
    }
}



@Composable
fun CreateProfile3(navController: NavController) {
    Background()
        BackgroundBox {
            TitleText("Er du klar til at mødes?")
            Text(text = "Foretrækker du at mødes når i bytter tøj? Indtast dit postnummer og se tøj tæt på dig!")
            InputField("Postnummer")
            Text(text="Radius i km")
            PurpleSlider(0F, 25F)
            GreenButton("Færdig", navController, "ProfileView")
    }
}

//profilview (ikkke eksisterende og pt enddestination)
@Composable
fun ProfileView (navController: NavController) {
    Background()
    Navbar()
}
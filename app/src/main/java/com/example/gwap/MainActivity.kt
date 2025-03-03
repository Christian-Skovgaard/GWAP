package com.example.gwap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
            navComponent()
        }
    }
}

@Composable
fun navComponent () {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "homeScreen", builder = {
        composable("homeScreen") {HomeScreen(navController)}
        composable("CreateProfile1") {CreateProfile1()}
    })
}


@Composable
fun HomeScreen (navController: NavController) {
    Column {
        Text(
            text = "Gwap",
            fontSize = 50.sp
        )
        Column {
            Button(onClick = {navController.navigate("CreateProfile1")}) {
                Text("Opret profil")
            }
        }
    }
}

@Composable
fun CreateProfile1 () {
    Text ("yes")
}

package com.example.navigationcomponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationcomponent.ui.theme.NavigationComponentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationComponentTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DisplayNavComponent()
                }
            }
        }
    }
}

@Composable
fun DisplayNavComponent() {
    var navController = rememberNavController()
    NavHost(navController = navController, startDestination = Destinations.MainScreen.toString()) {
        composable(Destinations.MainScreen.toString()) {
            MainScreen(navController)
        }

        composable(Destinations.HomeScreen.toString()) {
            HomeScreen(navController)
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Main Screen", fontSize = 30.sp)
        Button(onClick = { navController.navigate(Destinations.HomeScreen.toString()) }) {
            Text(text = "Go to Home Screen")
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    NavigationComponentTheme {
//        Greeting("Android")
//    }
//}
package com.example.navigationcomponent

sealed class Destinations (val route: String) {
     data object MainScreen: Destinations("MainScreen")
     data object HomeScreen: Destinations("HomeScreen")
}
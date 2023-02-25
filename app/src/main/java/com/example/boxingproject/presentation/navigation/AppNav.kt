package com.example.boxingproject.presentation.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class AppNav(
    val route: String,
    ) {

    //Login Route
    object LoginScreen : AppNav(route = "LoginScreen/{nameValue} ") {
        fun crearRouteNueva(nameValue: String) : String{
            return "LoginScreen/$nameValue"
        }
    }

    //Home Route
    object HomeScreen : AppNav("HomeScreen/{user}"){
        fun createRoute(user : String) : String {
            return "HomeScreen/$user"
        }
    }

    object RegistrationScreen : AppNav(route = "Registration")
    object PagoScreen : AppNav(route = "PagoScreen")
    object MenuScreen : AppNav(route = "MenuScreen")
}
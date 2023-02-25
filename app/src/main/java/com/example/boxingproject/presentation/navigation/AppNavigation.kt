package com.example.boxingproject.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.boxingproject.presentation.interactive.MenuScreen
import com.example.boxingproject.presentation.interactive.PagoScreen
import com.example.boxingproject.presentation.login.LoginScreen
import com.example.boxingproject.presentation.login.LoginViewModel
import com.example.boxingproject.presentation.screens.RegistrationScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppNav.LoginScreen.route
    ) {
        val viewModel = LoginViewModel()
        composable(route = AppNav.LoginScreen.route) {
            if( viewModel.state.value.successLogin ){
                LaunchedEffect(key1 = Unit){
                    navController.navigate(AppNav.HomeScreen.createRoute(viewModel.state.value.email)){
                        //Modificamos el historial de navegación para no poder regresar

                        popUpTo(AppNav.LoginScreen.route){
                            inclusive = true
                        }
                    }
                }
            } else {
            LoginScreen(
                navController,
                state = viewModel.state.value,
                onLogin = viewModel::login,
                onDissmissDialog = viewModel::hideErrorDialog,
                onNavigateToRegister = {
                    navController.navigate(AppNav.RegistrationScreen.route)
                }
            )
        }


        }// Fin de composable Login

        composable(route = AppNav.RegistrationScreen.route) {
            RegistrationScreen(navController)
        }
        composable(route = AppNav.MenuScreen.route) {
            MenuScreen(navController)
        }
        composable(route = AppNav.PagoScreen.route) {
            PagoScreen(navController)
        }

    }
}


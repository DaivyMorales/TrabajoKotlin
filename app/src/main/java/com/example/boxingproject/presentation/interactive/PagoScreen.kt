package com.example.boxingproject.presentation.interactive

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCard
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.boxingproject.presentation.navigation.AppNav

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")

@Composable
fun PagoScreen(navController: NavController){
    Scaffold(
        topBar ={
            TopAppBar(){
                Text(text = "Menu")
                Text(
                    text = "Cerrar Sesion",
                    /*modifier = Modifier.clickable {
                        navController.navigate(route = AppNav.LoginScreen.route)
                    }*/
                )
            }
        }
    ) {
        PagoScreenContent(navController)
    }
}

@Composable
fun PagoScreenContent(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Icon(imageVector = Icons.Default.AddCard, contentDescription = "Regresar al login",
            tint = MaterialTheme.colors.primary, modifier = Modifier.size(50.dp)
        )
        Text(text = "¡Gracias!", style = MaterialTheme.typography.h2.copy(color = Color.Blue, fontWeight = FontWeight.Bold))
        Text(text = "Haz comprado uno de nuestro productos", style = MaterialTheme.typography.h6.copy(color = Color.Black))
        Button(onClick = {
            navController.navigate(route = AppNav.MenuScreen.route)
        }) {
            Text(text = "Volver a la tienda")
        }
    }
}


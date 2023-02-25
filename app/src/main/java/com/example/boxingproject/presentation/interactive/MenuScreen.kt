package com.example.boxingproject.presentation.interactive

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.boxingproject.presentation.models.Guantes
import com.example.boxingproject.presentation.models.guantes
import com.example.boxingproject.presentation.navigation.AppNav

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")

@Composable
fun MenuScreen(navController: NavController){
    Scaffold(
        topBar ={
            TopAppBar(){
                Text(text = "Menu")
                Text(
                    text = "Cerrar Sesion",
                    modifier = Modifier.clickable {
                        navController.navigate(route = AppNav.LoginScreen.route)
                    }
                )
            }
        }
    ) {
        ProductsList(guantes, navController)
    }
}

@Composable
fun ProductsList( products : List<Guantes>, navController: NavController ){
    LazyColumn(){
        items(products){
            product -> GuanteCard( product.peso, product.marca, product.precio, product.foto, navController)
        }
    }
}

@Composable
fun GuanteCard( peso: String, marca: String, precio: Int, foto: Int, navController: NavController ){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(foto),
            contentDescription = null,
            modifier =Modifier.size(200.dp)
        )
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(text = peso, style = MaterialTheme.typography.h4.copy(color = Color.Blue))
            Text(text = marca, style = MaterialTheme.typography.h5.copy(color = Color.Black))
            Text(text = precio.toString())
            Button(onClick = {
                navController.navigate(route = AppNav.PagoScreen.route)
            }) {
                Text(text = "Comprar")
            }
        }

    }
}




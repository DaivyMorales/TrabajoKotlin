package com.example.boxingproject.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.boxingproject.presentation.components.RoundedButtom
import com.example.boxingproject.presentation.components.SocialMediaButton
import com.example.boxingproject.presentation.components.TransparentTextField
import com.example.boxingproject.presentation.navigation.AppNav

@Composable
fun RegistrationScreen( navController: NavController ){

    val nameValue = remember {
        mutableStateOf("")
    }

    val emailValue = remember {
        mutableStateOf("")
    }

    val phoneValue = remember {
        mutableStateOf("")
    }

    val passValue = remember {
        mutableStateOf("")
    }

    val confirmPassValue = remember {
        mutableStateOf("")
    }


    var passwordVisibility by remember {
        mutableStateOf(false)
    }

    var confirmPasswordVisibility by remember {
        mutableStateOf(false)
    }


    val focusManager =  LocalFocusManager.current

    Box( modifier = Modifier.fillMaxWidth() ){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = {
                    navController.navigate(route = AppNav.MenuScreen.route)
                }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Regresar al login",
                        tint = MaterialTheme.colors.primary
                    )
                }
                Text( text = "Crear una cuenta", style = MaterialTheme.typography.h6.copy(
                    color = MaterialTheme.colors.primary
                ))
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                TransparentTextField(  //Text nombre
                    textFieldValue = nameValue,
                    textLabel = "Name",
                    keyboardType = KeyboardType.Text,
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                    imeAction = ImeAction.Next,
                )

                TransparentTextField(  //Text Correo
                    textFieldValue = emailValue,
                    textLabel = "Correo",
                    keyboardType = KeyboardType.Email,
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                    imeAction = ImeAction.Next,
                )

                TransparentTextField(  //Text telefono
                    textFieldValue = phoneValue,
                    textLabel = "Telefono",
                    keyboardType = KeyboardType.Phone,
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                    imeAction = ImeAction.Next,
                )

                TransparentTextField(  //Text clave
                    textFieldValue = passValue,
                    textLabel = "Password",
                    keyboardType = KeyboardType.Password,
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                    imeAction = ImeAction.Next,
                )

                TransparentTextField(  //Text confirm clave
                    textFieldValue = confirmPassValue,
                    textLabel = "Confirm Password",
                    keyboardType = KeyboardType.Password,
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                    imeAction = ImeAction.Next,
                )


                Spacer(modifier = Modifier.height(16.dp) ) //Espacio
                RoundedButtom(text = "Sign Up", onClick = { navController.navigate(route = AppNav.MenuScreen.route) })  //Boton de Sign Up
                ClickableText(
                    text = buildAnnotatedString {
                        append("Already have a Account")
                        withStyle(
                            style = SpanStyle(
                                color = MaterialTheme.colors.primary,
                                fontWeight = FontWeight.Bold
                            )
                        ){
                            append("Log In")
                        }
                    } , onClick = {
                        //TODO{Login Screen}
                    }
                )
            }
            Spacer(modifier = Modifier.fillMaxWidth() )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Divider(
                        modifier = Modifier.width(24.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )//Linea Divisoria

                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "OR",
                        style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Black)
                    )
                    Divider(
                        modifier = Modifier.width(24.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )//LLinea Divisora
                    //Botones adicionales de redes sociales
                }
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Login With",
                    style = MaterialTheme.typography.body1.copy(MaterialTheme.colors.primary),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                //TODO { Creamos un nuevo Componente para los botones. }
                SocialMediaButton(
                    text = "Login With Facebook",
                    onClick = { /*TODO*/ },
                    socialMediaColor = MaterialTheme.colors.onSurface
                )

                SocialMediaButton(
                    text = "Login With Gmail",
                    onClick = { /*TODO*/ },
                    socialMediaColor = MaterialTheme.colors.primary
                )
            }
        }
    }
}

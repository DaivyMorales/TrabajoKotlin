package com.example.boxingproject.presentation.login

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.boxingproject.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class LoginViewModel : ViewModel() {

    val state : MutableState<LoginState> = mutableStateOf( LoginState() )

    fun login(email:String, pass:String){
        val errorMessage = if(email.isBlank() || pass.isBlank()){
            R.string.error_input_empty
        }else if( !Patterns.EMAIL_ADDRESS.matcher(email).matches() ){
            R.string.error_not_e_valid_email
        }else if(email != "n@n.com" || pass != "a"){
            R.string.error_invalid_credentials
        }
        else null

        errorMessage?.let {
            state.value = state.value.copy( errorMessages = it )
            return
        }

        viewModelScope.launch {
            state.value = state.value.copy(displayProgressBar = true)
            delay(3000)
            state.value = state.value.copy(email = email, pass = pass)
            state.value = state.value.copy(displayProgressBar = true)
            state.value = state.value.copy(successLogin = true)
        }
    }

    fun hideErrorDialog(){
        state.value = state.value.copy( errorMessages = null )
    }

}
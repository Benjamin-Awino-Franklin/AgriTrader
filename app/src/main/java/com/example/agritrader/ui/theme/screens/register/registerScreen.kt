package com.example.agritrader.ui.theme.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.agritrader.R
import com.example.agritrader.data.AuthViewModel
import com.example.agritrader.navigation.ROUTE_HOME
import com.example.agritrader.navigation.ROUTE_HOME2
//import com.example.agritrader.data.AuthViewModel
//import com.example.agritrader.navigation.ROUTE_LOGIN
//import com.example.agritrader.navigation.ROUTE_REGISTER
import com.example.agritrader.navigation.ROUTE_LOGIN
import com.example.agritrader.navigation.ROUTE_PHOME

@Composable
fun RegisterScreen(navController:NavHostController) {

    Box (modifier = Modifier.fillMaxSize())
    {
        Image(painter = painterResource(id = R.drawable.h),
            contentDescription ="Background Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize())
    }

    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    var confirmpass by remember { mutableStateOf(TextFieldValue("")) }
    var context= LocalContext.current



    Column(modifier = Modifier
        .fillMaxSize(),
        // .background(Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Welcome to AgriTrader",
            color = Color.Cyan,
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp)

        Text(text = "Register here",
            color = Color.Cyan,
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp)
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = email, onValueChange = { email = it },
            label = { Text(text = "Enter Email") },
            leadingIcon = {Icon(imageVector = Icons.Default.Email, contentDescription = "icon for email")},

            keyboardOptions = KeyboardOptions . Default . copy (imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

            )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value =pass , onValueChange = {pass=it},
            label = { Text(text = "Enter password") },
            leadingIcon = {Icon(imageVector = Icons.Default.Lock, contentDescription = "icon for pass")},

            visualTransformation = PasswordVisualTransformation(),

            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(value =confirmpass , onValueChange = {
            confirmpass=it},
            label = { Text(text = "Enter Confirm Pass") },
            leadingIcon = {Icon(imageVector = Icons.Default.Lock, contentDescription = "icon for pass")},

            visualTransformation = PasswordVisualTransformation(),


            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            val myregister= AuthViewModel(navController, context)
            myregister.signup(email.text.trim(), pass.text.trim(), confirmpass.text.trim())



        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Register ")

        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(ROUTE_LOGIN)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Have an Account? Click to Login")
        }

        Spacer(modifier = Modifier.height(20.dp))


        Button(onClick = {
            navController.navigate(ROUTE_PHOME)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Back")
        }
    }
}




@Preview(showSystemUi = true, showBackground = true)
@Composable
fun RegisterScreenPreview(){
    RegisterScreen(rememberNavController())
}

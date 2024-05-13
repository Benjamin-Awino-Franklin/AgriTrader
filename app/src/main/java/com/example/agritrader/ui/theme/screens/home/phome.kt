package com.example.agritrader.ui.theme.screens.home

import androidx.compose.animation.VectorConverter
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.agritrader.R
import com.example.agritrader.navigation.ROUTE_ADD_PRODUCT
import com.example.agritrader.navigation.ROUTE_REGISTER
import com.example.agritrader.navigation.ROUTE_REGISTER2
import com.example.agritrader.navigation.ROUTE_VIEW_PRODUCT


@Composable
fun HomeScreen1(navController: NavController){
    Box (modifier = Modifier.fillMaxSize())
    {
        Image(painter = painterResource(id = R.drawable.hhh),
            contentDescription ="Background Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize())
    }


    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context= LocalContext.current
        // var productdata=productviewmodel(navController,context)

        Text(text = "AgriTrader",
            color = Color.Cyan,
            fontFamily = FontFamily.SansSerif,
            fontSize = 30.sp)

        Spacer(modifier = Modifier.height(30.dp))


        Text(text = "Welcome to our Home page",
            color = Color.Cyan,
            fontFamily = FontFamily.SansSerif,
            fontSize = 30.sp)

        Spacer(modifier = Modifier.height(300.dp))

        Column (modifier=Modifier.height(400.dp).width(250.dp).background(color = Color.Transparent ,shape = RoundedCornerShape(100.dp))){
            Button(onClick = {
                navController.navigate(ROUTE_REGISTER)
            },modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp)
                .height(100.dp)) {
                Text(text = "Farmer")
            }

            Spacer(modifier = Modifier.height(1.dp))


            Button(onClick = {
                navController.navigate(ROUTE_REGISTER2)
            },modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp)
                .height(100.dp)) {
                Text(text = "Buyer")
            }

        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview1(){
    HomeScreen1(rememberNavController())
}
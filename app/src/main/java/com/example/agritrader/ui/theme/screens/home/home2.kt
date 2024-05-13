package com.example.agritrader.ui.theme.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.example.agritrader.navigation.ROUTE_VIEW_PRODUCT
import com.example.agritrader.navigation.ROUTE_VIEW_PRODUCT2
import com.example.agritrader.navigation.ROUTE_VIEW_UPLOAD
import com.example.agritrader.navigation.ROUTE_VIEW_UPLOADS


@Composable
fun HomeScreen2(navController: NavController){
    Box (modifier = Modifier.fillMaxSize())
    {
        Image(painter = painterResource(id = R.drawable.l),
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
            color = Color.Green,
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp)
        Text(text = "Welcome to Home page",
            color = Color.Green,
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp)

        Spacer(modifier = Modifier.height(100.dp))
        Button(onClick = {
            navController.navigate(ROUTE_VIEW_UPLOADS)
        },modifier = Modifier.fillMaxWidth().padding(50.dp)) {
            Text(text = "View uploads")
        }

        Spacer(modifier = Modifier.height(50.dp))
        Button(onClick = {
            navController.navigate(ROUTE_VIEW_PRODUCT2)
        },modifier = Modifier.fillMaxWidth().padding(50.dp)) {
            Text(text = "View Product")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview2(){
    HomeScreen2(rememberNavController())
}
package com.example.agritrader.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.agritrader.navigation.ROUTE_ABOUT
import com.example.agritrader.navigation.ROUTE_ADD_PRODUCT
import com.example.agritrader.navigation.ROUTE_HOME
import com.example.agritrader.navigation.ROUTE_LOGIN
import com.example.agritrader.navigation.ROUTE_REGISTER
import com.example.agritrader.navigation.ROUTE_UPDATE_PRODUCT
import com.example.agritrader.navigation.ROUTE_VIEW_PRODUCT
import com.example.agritrader.ui.theme.screens.home.HomeScreen
import com.example.agritrader.ui.theme.screens.login.LoginScreen
import com.example.agritrader.ui.theme.screens.login.RegisterScreen
import com.example.agritrader.ui.theme.screens.products.AddProductsScreen
import com.example.agritrader.ui.theme.screens.products.UpdateProductsScreen
import com.example.agritrader.ui.theme.screens.products.ViewProductsScreen
import com.example.agritrader.ui.theme.screens.about.AboutScreen
import com.example.agritrader.ui.theme.screens.home.HomeScreen1
import com.example.agritrader.ui.theme.screens.home.HomeScreen2
import com.example.agritrader.ui.theme.screens.login.LoginScreen2
import com.example.agritrader.ui.theme.screens.login.RegisterScreen2
import com.example.agritrader.ui.theme.screens.products.ViewProductsScreens
import com.example.agritrader.ui.theme.screens.products.ViewUploadsScreen
import com.example.agritrader.ui.theme.screens.products.ViewUploadsScreens

@Composable
fun AppNavHost(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController(), startDestination: String= ROUTE_PHOME){
    NavHost(navController = navController, modifier = Modifier, startDestination = startDestination) {
        composable(ROUTE_HOME) {
            HomeScreen(navController)
        }
        composable(ROUTE_PHOME){
            HomeScreen1(navController)
        }
        composable(ROUTE_ABOUT) {
            AboutScreen(navController)
        }
        composable(ROUTE_REGISTER) {
            RegisterScreen(navController)
        }
        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
        }
        composable(ROUTE_ADD_PRODUCT) {
            AddProductsScreen(navController)
        }
        composable(ROUTE_UPDATE_PRODUCT + "/{id}") { passedData ->
            UpdateProductsScreen(navController, passedData.arguments?.getString("id")!!)
        }
        composable(ROUTE_VIEW_PRODUCT) {
            ViewProductsScreen(navController)
        }
        composable(ROUTE_VIEW_PRODUCT2){
            ViewProductsScreens(navController)
        }
        composable(ROUTE_VIEW_UPLOAD){
            ViewUploadsScreen(navController)
        }
        composable(ROUTE_VIEW_UPLOADS){
            ViewUploadsScreens(navController)
        }
        composable(ROUTE_REGISTER2){
            RegisterScreen2(navController)
        }
        composable(ROUTE_LOGIN2){
            LoginScreen2(navController)
        }
        composable(ROUTE_HOME2){
            HomeScreen2(navController)
        }
    }
}
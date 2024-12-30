package com.example.consumerestapi.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.consumerestapi.ui.view.DestinasiDetail
import com.example.consumerestapi.ui.view.DestinasiEntry
import com.example.consumerestapi.ui.view.DestinasiHome
import com.example.consumerestapi.ui.view.DestinasiUpdate
import com.example.consumerestapi.ui.view.DetailView
import com.example.consumerestapi.ui.view.EntryMhsScreen
import com.example.consumerestapi.ui.view.HomeScreen
import com.example.consumerestapi.ui.view.UpdateScreen

@Composable
fun PengelolaHalaman(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier,
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                onDetailClick = {
                }
            )
        }
        composable(DestinasiEntry.route) {
            EntryMhsScreen(navigateBack = {
                navController.navigate(DestinasiHome.route) {
                    popUpTo(DestinasiHome.route) {
                        inclusive = true
                    }
                }
            })
        }
        composable(
            route = "${DestinasiDetail.route}/{nim}",
        ) { backStackEntry ->

            val nim = backStackEntry.arguments?.getString("nim") ?: ""

            DetailView(
                nim = nim,
                navigateBack = { navController.popBackStack() },
                onClick = {
                    navController.navigate("${DestinasiUpdate.route}/$nim")
                }
            )
        }
        composable(
            route = "${DestinasiUpdate.route}/{nim}",
            arguments = listOf(navArgument("nim") { type = NavType.StringType })
        ) { backStackEntry ->
            val nim = backStackEntry.arguments?.getString("nim") ?: ""
            UpdateScreen(
                nim = nim,
                navigateBack = {
                    navController.navigate(DestinasiHome.route) {
                        popUpTo(DestinasiHome.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}
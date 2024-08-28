package com.example.tripcalculator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tripcalculator.Route.TRIP_PRICE

object Route{
    const val START = "start"
    const val DISTANCE="Distance "
    const val TIME="time"
    const val TRAFFIC_OPTIONS = "traffic_options"
    const val TRIP_PRICE="trip-price"
}


@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination =Route.START ){
        composable(route=Route.START){
            StartScreen(navController)
        }
        composable(route=Route.DISTANCE){
            DistanceScreen(navController)
        }
        composable(
            route="${Route.TIME}/{km}",
            arguments =listOf(
                navArgument("km"){
                    type=NavType.FloatType
                }
            )
            ){
            val km=it.arguments?.getFloat("km")!!
            TimeScreen(navController, distane =km )
        }
        composable(
            route = "${Route.TRAFFIC_OPTIONS}/{km}/{trip_time}",
            arguments = listOf(
                navArgument("km") { type = NavType.FloatType },
                navArgument("trip_time") { type = NavType.IntType }
            )
        ) {
            val km = it.arguments?.getFloat("km")!!
            val time = it.arguments?.getInt("trip_time")!!
            Options(navController, distance = km, time = time)

     }
        composable(
            route = "$TRIP_PRICE/{km}/{trip_time}/{traffic}",
            arguments = listOf(
                navArgument("km") { type = NavType.FloatType },
                navArgument("trip_time") { type = NavType.IntType },
                navArgument("traffic") { type = NavType.FloatType }
            )
        ) {
            val km = it.arguments?.getFloat("km")!!
            val time = it.arguments?.getInt("trip_time")!!
            val traffic = it.arguments?.getFloat("traffic")!!
            TripPriceScreen(navController, km = km, time = time, traffic = traffic)
        }
    }
}
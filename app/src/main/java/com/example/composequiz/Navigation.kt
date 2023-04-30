package com.example.composequiz

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composequiz.ui.*

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route){
        composable(route = Screen.HomeScreen.route){
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.QuesOneScreen.route
        ){
            QuesOneScreen(navController = navController)
        }
        composable(
            route = Screen.QuesTwoScreen.route + "/{result1}",
            arguments = listOf(
                navArgument("result1"){
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ){entry ->
            QuesTwoScreen(navController = navController, marks = entry.arguments?.getInt("result1"))
        }
        composable(
            route = Screen.QuesThreeScreen.route + "/{result2}",
            arguments = listOf(
                navArgument("result2"){
                    type = NavType.IntType
                }
            )
        ){entry ->
            QuesThreeScreen(navController = navController, entry.arguments?.getInt("result2"))
        }
        composable(
            route = Screen.QuesFourScreen.route + "/{result3}",
            arguments = listOf(
                navArgument("result3"){
                    type = NavType.IntType
                }
            )
        ){entry->
            QuesFourScreen(
                navController = navController,
                marks = entry.arguments?.getInt("result3")
            )
        }
        composable(
            route = Screen.QuesFiveScreen.route + "/{result4}",
            arguments = listOf(
                navArgument("result4"){
                    type = NavType.IntType
                }
            )
        ){entry->
            QuesFiveScreen(
                navController = navController,
                marks = entry.arguments?.getInt("result4")
            )
        }
        composable(
            route = Screen.ResultScreen.route + "/{result5}",
            arguments = listOf(
                navArgument("result5"){
                    type = NavType.IntType
                }
            )
        ){entry->
            ResultScreen(navController = navController, marks = entry.arguments?.getInt("result5"))
        }
    }
}
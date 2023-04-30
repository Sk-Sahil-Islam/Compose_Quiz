package com.example.composequiz

sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
    object QuesOneScreen: Screen("ques_one_screen")
    object QuesTwoScreen: Screen("ques_two_screen")
    object QuesThreeScreen: Screen("ques_three_screen")
    object QuesFourScreen: Screen("ques_four_screen")
    object QuesFiveScreen: Screen("ques_five_screen")
    object ResultScreen: Screen("result_screen")
}
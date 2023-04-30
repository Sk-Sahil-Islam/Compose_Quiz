package com.example.composequiz.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composequiz.Screen
import com.example.composequiz.ui.theme.MyGreen

@Composable
fun HomeScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = "This is the home page, start the quiz by clicking the button above.",
            modifier = Modifier.align(Alignment.BottomStart)
        )

        Button(
            colors = ButtonDefaults.buttonColors(MyGreen),
            onClick = {
            navController.navigate(Screen.QuesOneScreen.route)
        }) {
            Text("Start")
        }
    }
}
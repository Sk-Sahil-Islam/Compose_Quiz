package com.example.composequiz.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composequiz.Screen
import com.example.composequiz.ui.theme.MyGreen

@Composable
fun ResultScreen(
    navController: NavController,
    marks: Int?
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding((16.dp)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Your Score:",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = MyGreen
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = "$marks",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            Button(onClick = {
                navController.navigate(Screen.HomeScreen.route){
                    popUpTo(Screen.HomeScreen.route){ inclusive = true }
                }
            },
                colors = ButtonDefaults.buttonColors(MyGreen),
                modifier = Modifier.weight(1f,true)
            ) {
                Text(text = "Play Again")
            }
            Spacer(modifier = Modifier.size(16.dp))
            Button(onClick = {

            },
                colors = ButtonDefaults.buttonColors(MyGreen),
                modifier = Modifier.weight(1f, true)
            ) {
                Text(text = "Share")
            }
        }
    }
}

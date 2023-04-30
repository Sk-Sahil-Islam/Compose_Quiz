package com.example.composequiz.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composequiz.Screen
import com.example.composequiz.ui.theme.MyGreen

@Composable
fun QuesOneScreen(
    navController: NavController
) {
    var result by remember {
        mutableStateOf(0)
    }
    val optionList by remember {
        mutableStateOf(
            listOf(
                "Ethiopia",
                "Bermuda",
                "Nicaragua",
                "Slovakia"
            )
        )
    }
    var answer by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Question 1:",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Which country features a shipwreck on its national flag?",
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            optionList.forEach {
                Row {
                    RadioButton(
                        selected = answer == it,
                        onClick = {
                            answer = it
                        },
                        colors = RadioButtonDefaults.colors(MyGreen)
                    )
                    Text(
                        text = it,
                        modifier = Modifier.align(CenterVertically),
                        fontSize = 17.sp
                    )
                }
            }
            Spacer(modifier = Modifier.size(16.dp))
            if(answer.isNotBlank()){
                Button(
                    colors = ButtonDefaults.buttonColors(MyGreen),
                    modifier = Modifier.align(End),
                    onClick = {
                        if (answer == "Bermuda") result++
                        navController.navigate(Screen.QuesTwoScreen.route + "/$result")
                    }) {
                    Text(text = "Next")
                }
            }
        }
    }
}
package com.example.composequiz.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composequiz.Screen
import com.example.composequiz.ui.theme.MyGreen

@Composable
fun QuesThreeScreen(
    navController: NavController,
    marks: Int?
) {
    var result by remember {
        mutableStateOf(marks)
    }
    val optionList by remember {
        mutableStateOf(
            listOf(
                "Nike",
                "Amazon",
                "Nintendo",
                "Puma"
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
                text = "Question 3:",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "What company was originally called \"Cadabra\"?",
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
                        modifier = Modifier.align(Alignment.CenterVertically),
                        fontSize = 17.sp
                    )
                }
            }
            Spacer(modifier = Modifier.size(16.dp))
            if (answer.isNotBlank()){
                Button(
                    colors = ButtonDefaults.buttonColors(MyGreen),
                    modifier = Modifier.align(Alignment.End),
                    onClick = {
                        if (answer == "Amazon") result = result!! + 1
                        navController.navigate(Screen.QuesFourScreen.route + "/$result")
                    }) {
                    Text(text = "Next")
                }
            }
        }
    }
}
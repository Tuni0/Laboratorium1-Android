package com.example.lab1
import com.example.lab1.SecondView

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add

import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.room.*
import com.example.lab1.ui.theme.Lab1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {

    var x by remember { mutableStateOf(0) }
    var Click by remember { mutableStateOf(false) }
    var showSecondView by remember { mutableStateOf(false) }


    Scaffold(
        containerColor = Color.Black,

        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Color(0xFF242424),
                    titleContentColor = Color(0xB3FFFFFF),
                ),
                title = {
                    Text("Top app bar")
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xFF242424),
                contentColor = Color(0xB3FFFFFF),
            ) {

                Button(
                    onClick = {showSecondView = true }
                ) {
                    Icon(Icons.Filled.Add, contentDescription = "Add")


                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                     x+=1
                     Click = true
                },

                ) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }
        }


    ) { innerPadding ->
        if (Click) {


            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    color = Color(0xFFFFFFFF),
                    modifier = Modifier.padding(8.dp),
                    text = x.toString(),
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp,
                )
            }

        }



    }
    if(showSecondView){
        AnimatedVisibility(visible = true) {
            SecondView()}

    }
}
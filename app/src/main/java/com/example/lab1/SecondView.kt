package com.example.lab1


import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

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
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.room.*
import com.example.lab1.ui.theme.Lab1Theme
@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SecondView() {
    var x by remember { mutableStateOf(0) }

    var showThirdView by remember { mutableStateOf(false) }
    var Click by remember { mutableStateOf(false) }

    Scaffold(
        containerColor = Color.Black,
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black,
                ),
                title = {
                    Text("Top app bar")
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Red,
                contentColor = Color(0xB3FFFFFF),
            ) {
                Button(
                    onClick = {showThirdView = true }
                ) {
                    Icon(Icons.Filled.Add, contentDescription = "Add")


                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    x += 1
                    Click = true
                },
            ) {
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
    if(showThirdView){
        ThirdView()
    }
}
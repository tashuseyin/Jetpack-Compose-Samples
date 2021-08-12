package com.example.jetpackcomposetoolbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Toolbar()
        }
    }
}


@Composable
fun Toolbar() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Demo App")
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Filled.Menu, contentDescription = "menu")
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Filled.Search, contentDescription = "search")
                    }
                    IconButton(onClick = { }) {
                        Icon(Icons.Filled.Notifications, contentDescription = "notifications")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.Add, contentDescription = "add")
                }

            }
        },
        floatingActionButtonPosition = FabPosition.End
    )
    {

        Text(
            text = "Hello World", modifier = Modifier.fillMaxSize(),
            style = TextStyle(
                color = Color.Blue,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        )


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Toolbar()
}
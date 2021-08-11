package com.example.jetpackcomposeuielements

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun HorizontalMainScreen() {
    Surface(
        color = Color.DarkGray,
        modifier = Modifier.fillMaxSize(),
    ) {

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            HorizontalColoredBar(Color.Red)
            HorizontalColoredBar(Color.Magenta)
            HorizontalColoredBar(Color.Blue)
            HorizontalColoredBar(Color.Green)
            HorizontalColoredBar(Color.Cyan)
        }
    }
}

@Composable
fun VerticalMainScreen() {
    Surface(
        color = Color.DarkGray,
        modifier = Modifier.fillMaxSize(),
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            VerticalColoredBar(Color.Red)
            VerticalColoredBar(Color.Magenta)
            VerticalColoredBar(Color.Blue)
            VerticalColoredBar(Color.Green)
            VerticalColoredBar(Color.Cyan)
        }
    }
}


@Composable
fun MainScreen(){
    Surface(
        color = Color.DarkGray,
        modifier = Modifier.fillMaxSize(),
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                VerticalColoredBar(Color.Red)
                VerticalColoredBar(Color.Magenta)
            }
            VerticalColoredBar(Color.Blue)
            VerticalColoredBar(Color.Green)
            VerticalColoredBar(Color.Green)
        }
    }

}



@Composable
fun HorizontalColoredBar(color: Color) {
    Surface(
        color = color, modifier = Modifier
            .width(60.dp)
            .height(500.dp)
    ) {
    }
}

@Composable
fun VerticalColoredBar(color: Color) {
    Surface(
        color = color, modifier = Modifier
            .padding(all = 8.dp)
            .width(100.dp)
            .height(60.dp)
    ) {
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}
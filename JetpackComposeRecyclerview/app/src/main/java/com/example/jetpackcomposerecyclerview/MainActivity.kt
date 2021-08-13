package com.example.jetpackcomposerecyclerview

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposerecyclerview.ui.theme.JetpackComposeRecyclerviewTheme
import com.example.jetpackcomposerecyclerview.uitel.PuppyCard
import com.example.jetpackcomposerecyclerview.viewmodel.PuppyViewModel

class MainActivity : ComponentActivity() {

    private val puppyViewModel: PuppyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val puppyList = puppyViewModel.puppysList.value
            puppyList?.let {
                SetPuppyList(puppyList = it, context = this)
            }
        }
    }
}

@Composable
fun SetPuppyList(puppyList: List<PuppyData>,context: Context) {
    LazyColumn {
        itemsIndexed(items = puppyList) { _, itemPuppy ->
            PuppyCard(puppyData = itemPuppy, onClick = {
                Toast.makeText(context, itemPuppy.puppyName, Toast.LENGTH_SHORT).show()
            })
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeRecyclerviewTheme {

    }
}
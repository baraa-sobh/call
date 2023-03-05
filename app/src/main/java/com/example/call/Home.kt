package com.example.call

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.call.ui.theme.CallTheme

class Home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CallTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AddBtn()
                }
            }
        }
    }
}

@Composable
fun AddBtn() {

    var context = LocalContext.current

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
            var i = Intent(context ,Add::class.java)
                context.startActivity(i)

            }, contentColor = Color.White) {
                Icon(imageVector = Icons.Default.Add,
                    contentDescription = "add",

                    )
            }
        }

    ) {
        it
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    CallTheme {
        AddBtn()
    }
}
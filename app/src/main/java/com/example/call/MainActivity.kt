package com.example.call

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.call.ui.theme.CallTheme
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        Handler().postDelayed({
            val i = Intent(this,Home::class.java)
            startActivity(i)
            finish()
        },3000)
        setContent {
            CallTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                ) {
                    SplashScreen()
                }
            }
        }
    }
}

@Composable
fun SplashScreen() {

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Cyan), contentAlignment = Alignment.Center) {

        Column( modifier =Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            ) {

            Image(
                painter = painterResource(id = R.drawable.phone),
                contentDescription = "phone",
                modifier = Modifier.size(200.dp)
                )


        }
        
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CallTheme {
        SplashScreen()
    }
}
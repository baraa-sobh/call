package com.example.call

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.call.Model.MyFirebase
import com.example.call.ui.theme.CallTheme
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Add : ComponentActivity() {
    lateinit var db: FirebaseFirestore
    private val viewModel by viewModels<MyFirebase>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = Firebase.firestore



        setContent {
            CallTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AddUser(viewModel)
                }
            }
        }
    }


}

@Composable
fun AddUser(viewModel: MyFirebase) {
    var context = LocalContext.current
    var name by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {

        OutlinedTextField(
            value = name, onValueChange = { name = it },
            placeholder = { Text(text = "Enter Your Name") },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Green,
                unfocusedIndicatorColor = Color.Red
            )
        )
        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = number, onValueChange = { number = it },
            placeholder = { Text(text = "Enter Your Number") },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Green,
                unfocusedIndicatorColor = Color.Red
            )
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = address, onValueChange = { address = it },
            placeholder = { Text(text = "Enter Your Address") },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Green,
                unfocusedIndicatorColor = Color.Red
            )
        )
        Spacer(modifier = Modifier.height(30.dp))
//add to firbase
        Button(
            onClick = {

                val person = Person(name, number, address)
                 viewModel.addUser(person)


            }, modifier = Modifier, colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Cyan
            )
        ) {

            Text(text = "Save")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    CallTheme {
        //AddUser()
    }
}

@Composable
fun MyCard(name: String, number: String, address: String) {


    Card(
        modifier = Modifier.size(height = 130.dp, width = 200.dp),
        elevation = 10.dp
    ) {

        //TextField(value = name, onValueChange ={name = it} )

    }

}

@Preview
@Composable
fun MyCardPreview() {

}
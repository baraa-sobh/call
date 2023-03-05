package com.example.call.Model

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.call.Person
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MyFirebase : ViewModel() {
    private val db = Firebase.firestore
    private val auth = Firebase.auth


    fun addUser(person: Person) {
        var user = hashMapOf("Name" to person.name , "Number" to person.number , "Address" to person.address)

        db!!.collection("users").add(user)
            .addOnSuccessListener {it ->
                Log.e("baraa","user is don${it.id}")
               // Toast.makeText(this,"vvvvvvvv",Toast.LENGTH_LONG).show()

            }
            .addOnFailureListener{it
                Log.e("baraa","user is not error don${it.message}")
            }
    }

}
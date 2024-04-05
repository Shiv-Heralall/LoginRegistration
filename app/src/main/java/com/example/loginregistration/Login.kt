package com.example.loginregistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class Login : AppCompatActivity() {
    lateinit var email: EditText
    private lateinit var password: EditText
    lateinit var login: Button
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        login = findViewById(R.id.btn_login )
        auth = FirebaseAuth.getInstance()

        login.setOnClickListener{
            login()
        }

    }

    private fun login(){
        val email = email.text.toString()
        val password = password.text.toString()

        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this,"Successfully Logged in ", Toast.LENGTH_SHORT).show()
                    finish()
                }
                else{
                    Toast.makeText(this,"Incorrect Credentials", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
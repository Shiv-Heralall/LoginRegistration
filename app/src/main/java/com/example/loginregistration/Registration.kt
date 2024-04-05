package com.example.loginregistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class Registration : AppCompatActivity() {
lateinit var auth:FirebaseAuth
private lateinit var registerpassword:EditText
private lateinit var registeremail:EditText
lateinit var redirectlogin: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        registerpassword = findViewById(R.id.password)
        registeremail = findViewById(R.id.email)
        redirectlogin = findViewById(R.id.btn_register)
        auth = Firebase.auth
        redirectlogin.setOnClickListener {
            Register()
        }
        redirectlogin.setOnClickListener{
            val intent = Intent(this,Login::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun Register(){
        val email = registeremail.text.toString()
        val password = registerpassword.text.toString()

        if (email.isBlank() || password.isBlank() ){
            Toast.makeText(this,"Email and password cannot be blank",Toast.LENGTH_SHORT).show()
            return
        }
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this){

            if (it.isSuccessful){
                Toast.makeText(this,"Successfully Registered",Toast.LENGTH_SHORT).show()
                finish()
            }
            else{
                Toast.makeText(this,"Registration Failed",Toast.LENGTH_SHORT).show()
            }
        }

    }
}

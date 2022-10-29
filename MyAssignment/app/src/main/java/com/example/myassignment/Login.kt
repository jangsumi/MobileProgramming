package com.example.myassignment;

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
ㅑmport android.widget.Toast



class Login : AppCompatActivity() {
    private lateinit var LoginBtn: Button
    private lateinit var JoinBtn: Button
    private lateinit var NonMemBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        LoginBtn = findViewById(R.id.btn_login)
        JoinBtn = findViewById(R.id.btn_join)
        NonMemBtn = findViewById(R.id.btn_nonmember)

        LoginBtn.setOnClickListener {
//            if (같으면) {
                startActivity(Intent(this, Product::class.java))
//            } else {
//
//            }
        }
        JoinBtn.setOnClickListener {
            startActivity(Intent(this, Join::class.java))
        }
        NonMemBtn.setOnClickListener{
            startActivity(Intent(this, Product::class.java))
        }




    }





}
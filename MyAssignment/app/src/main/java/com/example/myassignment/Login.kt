package com.example.myassignment

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import org.json.JSONObject


class Login : AppCompatActivity() {
    private lateinit var LoginBtn: Button
    private lateinit var JoinBtn: Button
    private lateinit var NonMemBtn: Button

    private lateinit var InputId: EditText
    private lateinit var InputPw: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        LoginBtn = findViewById(R.id.btn_login)
        JoinBtn = findViewById(R.id.btn_join)
        NonMemBtn = findViewById(R.id.btn_nonmember)

        InputId = findViewById(R.id.input_id)
        InputPw = findViewById(R.id.input_pw)

        val prefs: SharedPreferences = getSharedPreferences("JoinInfo", 0)

        LoginBtn.setOnClickListener {
            var userId = InputId.text.toString()
            var userPw = InputPw.text.toString()

            if (userId.isNotEmpty() && userPw.isNotEmpty()) {
                var isAvailable = prefs.getString(userId, "none")

                if ( isAvailable == "none") {
                    Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
                }
                else{
                    var info = JSONObject(isAvailable)
                    if (userPw != info.getString("password")) {
                        Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
                    } else {
                        val intent = Intent(this, Product::class.java)
                        intent.putExtra("myInfoName", info.getString("name"))
                        intent.putExtra("myInfoAd", info.getString("address"))
                        intent.putExtra("myInfoTel", info.getString("tel"))
                        startActivity(intent)
                    }
                }
            } else {
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            }
        }
        JoinBtn.setOnClickListener {
            startActivity(Intent(this, Join::class.java))
        }
        NonMemBtn.setOnClickListener{
            startActivity(Intent(this, Product::class.java))
        }
    }
}
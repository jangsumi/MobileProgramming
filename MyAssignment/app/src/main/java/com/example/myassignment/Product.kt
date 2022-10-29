package com.example.myassignment

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Product: AppCompatActivity() {
    lateinit var alert_infoBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        alert_infoBtn = findViewById(R.id.infoBtn)

        alert_infoBtn.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("My Information")
                .setMessage("이름: 장수미" +
                        "나이: 23살" +
                        "직업: 최지원 여자친구")
                .setPositiveButton("닫기", DialogInterface.OnClickListener {
                        dialogInterface, i -> Toast.makeText(this, "", Toast.LENGTH_SHORT)
                })
            builder.show()
        }
    }
}

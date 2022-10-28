package com.example.myassignment

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Join: AppCompatActivity() {
    lateinit var EditId: EditText
    lateinit var EditPw: EditText
    lateinit var EditName: EditText
    lateinit var EditTel: EditText
    lateinit var EditAd: EditText

    lateinit var btn: Button

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        EditId = findViewById(R.id.input_join_id)
        EditPw = findViewById(R.id.input_join_pw)
        EditName = findViewById(R.id.input_join_name)
        EditTel = findViewById(R.id.input_join_tel)
        EditAd = findViewById(R.id.input_join_ad)

        btn = findViewById(R.id.btn_ok)

        val prefs: SharedPreferences = getSharedPreferences("JoinInfo", 0)
        val editor: SharedPreferences.Editor = prefs.edit()



        btn.setOnClickListener {
            val id: String = EditId.text.toString()
            val pw: String = EditPw.text.toString()
            val name: String = EditName.text.toString()
            val tel: String = EditTel.text.toString()
            val ad: String = EditAd.text.toString()
            val info = setOf(pw, name, tel, ad)

            editor.putStringSet(id, info)
            editor.apply()
        }
    }
    @Override
    override fun onDestroy() {
        super.onDestroy()
    }
}
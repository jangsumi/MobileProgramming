package com.example.myassignment

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import java.util.regex.Pattern

class Join: AppCompatActivity() {
    lateinit var EditId: EditText
    lateinit var EditPw: EditText
    lateinit var EditName: EditText
    lateinit var EditTel: EditText
    lateinit var EditAd: EditText

    lateinit var btn: Button
    lateinit var checkbtn: Button

    var available_id: String = ""

    lateinit var warningtextid: TextView
    lateinit var warningtextpw: TextView

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
        checkbtn = findViewById(R.id.btn_check)



        warningtextid = findViewById(R.id.warning_id)
        warningtextpw = findViewById(R.id.warning_pw)

        val prefs: SharedPreferences = getSharedPreferences("JoinInfo", 0)
        val editor: SharedPreferences.Editor = prefs.edit()

        warningtextid.visibility = View.INVISIBLE

        checkbtn.setOnClickListener {
            var userId = EditId.text.toString()
            var isAvailable = prefs.getString(userId, "no id")

            if (isAvailable == "no id") {
                warningtextid.visibility = View.INVISIBLE
                available_id = userId
            } else {
                warningtextid.visibility = View.VISIBLE
            }
        }

        warningtextpw.visibility = View.INVISIBLE


        val pwReg = "^.*(?=^.{8,15}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$"
        val pwPattern = Pattern.compile(pwReg)



        btn.setOnClickListener {
            var userId = EditId.text.toString()
            var userPw = EditPw.text.toString()

            if (!pwPattern.matcher(userPw).find()) {
                warningtextpw.visibility = View.VISIBLE
            } else {
                if (available_id != userId) {
                    warningtextid.visibility = View.VISIBLE
                } else {
                        var userName = EditName.text.toString()
                        var userAd = EditAd.text.toString()
                        var userTel = EditTel.text.toString()

                        val userInfoJson = JSONObject()
                        userInfoJson.put("password", userPw)
                        userInfoJson.put("name", userName)
                        userInfoJson.put("address", userAd)
                        userInfoJson.put("tel", userTel)

                        val userinfoString = userInfoJson.toString()

                        editor.putString(userId, userinfoString)
                        editor.apply()

                        startActivity(Intent(this, Login::class.java))
                }
            }
        }

    }
    @Override
    override fun onDestroy() {
        super.onDestroy()
    }
}
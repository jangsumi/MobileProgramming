package com.example.myassignment

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.myassignment.databinding.ActivityProductBinding


class Product: AppCompatActivity() {
    private val binding by lazy { ActivityProductBinding.inflate(layoutInflater) }
    private var itemAdapter: ItemAdapter? = null
    private lateinit var alert_infoBtn: Button

    private val datas = arrayOf(
        ItemData("초록 카라티", R.drawable.pic1),
        ItemData("검정 블루종", R.drawable.pic2),
        ItemData("남색 카라티", R.drawable.pic3),
        ItemData("회색 맨투맨", R.drawable.pic4),
        ItemData("검정 기본티", R.drawable.pic5),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        itemAdapter = ItemAdapter(datas)
        binding.recyclerView.adapter = itemAdapter


        val name = intent.getStringExtra("myInfoName")
        val tel = intent.getStringExtra("myInfoTel")
        val address = intent.getStringExtra("myInfoAd")

        alert_infoBtn = findViewById(R.id.infoBtn)
        alert_infoBtn.setOnClickListener {

            if (name == null){
                val builder = AlertDialog.Builder(this)
                builder.setTitle("비회원으로 쇼핑중")
                    .setMessage("로그인시 이용할 수 있는 서비스 입니다. 회원가입 하시겠습니까?")
                    .setNegativeButton("닫기", DialogInterface.OnClickListener { dialogInterface, i ->
                        Toast.makeText(this, "", Toast.LENGTH_SHORT)
                    })
                    .setPositiveButton("회원가입하기", DialogInterface.OnClickListener { dialogInterface, i ->
                        Toast.makeText(this, "", Toast.LENGTH_SHORT)
                        startActivity(Intent(this, Join::class.java))
                    })
                builder.show()

            }
            else {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("My Information")
                    .setMessage("이름: $name\n" + "전화번호: $tel\n" + "주소: $address\n")
                    .setPositiveButton("닫기", DialogInterface.OnClickListener { dialogInterface, i ->
                        Toast.makeText(this, "", Toast.LENGTH_SHORT)
                    })
                builder.show()
            }
        }
    }
}

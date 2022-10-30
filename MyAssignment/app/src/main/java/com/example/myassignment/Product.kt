package com.example.myassignment

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myassignment.databinding.ActivityProductBinding
import com.example.myassignment.databinding.AlertdialogEdittextBinding


class Product: AppCompatActivity() {
    private val binding by lazy { ActivityProductBinding.inflate(layoutInflater) }
    private var itemAdapter: ItemAdapter? = null
    private lateinit var alert_infoBtn: Button


    private val datas = arrayListOf(
        ItemData("초록 카라티", R.drawable.pic1),
        ItemData("검정 블루종", R.drawable.pic2),
        ItemData("남색 카라티", R.drawable.pic3),
        ItemData("회색 맨투맨", R.drawable.pic4),
        ItemData("검정 기본티", R.drawable.pic5),
        ItemData("검정 가디건", R.drawable.pic6),
        ItemData("진녹색 패딩", R.drawable.pic7),
        ItemData("검정 털집업", R.drawable.pic8),
        ItemData("검정 무스탕", R.drawable.pic9)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        itemAdapter = ItemAdapter(datas)
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.adapter = itemAdapter


        val name = intent.getStringExtra("myInfoName")
        val tel = intent.getStringExtra("myInfoTel")
        val address = intent.getStringExtra("myInfoAd")

        alert_infoBtn = findViewById(R.id.infoBtn)
        alert_infoBtn.setOnClickListener {

            if (name == null) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("비회원으로 쇼핑중")
                    .setMessage("로그인시 이용할 수 있는 서비스 입니다. 회원가입 하시겠습니까?")
                    .setNegativeButton("닫기", DialogInterface.OnClickListener { dialogInterface, i ->
                        Toast.makeText(this, "", Toast.LENGTH_SHORT)
                    })
                    .setPositiveButton(
                        "회원가입하기",
                        DialogInterface.OnClickListener { dialogInterface, i ->
                            Toast.makeText(this, "", Toast.LENGTH_SHORT)
                            startActivity(Intent(this, Join::class.java))
                        })
                builder.show()

            } else {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("My Information")
                    .setMessage("이름: $name\n" + "전화번호: $tel\n" + "주소: $address\n")
                    .setPositiveButton("닫기", DialogInterface.OnClickListener { dialogInterface, i ->
                        Toast.makeText(this, "", Toast.LENGTH_SHORT)
                    })
                builder.show()
            }
        }

        binding.additembtn.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("상품 관리")
                .setNegativeButton("상품 추가", DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(this, "", Toast.LENGTH_SHORT)
                    datas.add(ItemData("새로운 상품", R.drawable.pic10))
                    itemAdapter!!.notifyDataSetChanged()
                })
                .setPositiveButton("상품 삭제", DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(this, "", Toast.LENGTH_SHORT)
                    showDialogRemove()
                })
            builder.show()

        }
    }

    private fun showDialogRemove() {
        val builder = AlertDialog.Builder(this)
        val builderItem = AlertdialogEdittextBinding.inflate(layoutInflater)
        val editText = builderItem.editText


        with(builder) {
            setTitle("상품 삭제")
            setMessage("삭제할 상품의 번호를 입력하세요.")
            setView(builderItem.root)
            setPositiveButton("삭제") { _: DialogInterface, _ ->
                try {
                    var i = Integer.parseInt(editText.text.toString())
                    if (i <= datas.size - 1) {
                        datas.remove(datas[i-1])
                        itemAdapter!!.notifyDataSetChanged()
                    } else {
                        Toast.makeText(binding.root.context, "", Toast.LENGTH_SHORT)
                    }
                } catch (e: NumberFormatException) {
                    Toast.makeText(binding.root.context, "", Toast.LENGTH_SHORT)
                }
            }
            builder.show()
        }
    }

}
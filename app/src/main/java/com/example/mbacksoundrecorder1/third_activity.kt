package com.example.mbacksoundrecorder1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_third.*

class third_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

    btn_3.setOnClickListener {
        Log.d("aaa","buton 3 e basıldı")
        Intent(Intent.ACTION_GET_CONTENT).also {
            it.type="image/*"
            startActivityForResult(it,0)
        }
    }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val myuri=data?.data
        Log.d("aaa",myuri.toString())
        imgv_1.setImageURI(myuri)
    }
}
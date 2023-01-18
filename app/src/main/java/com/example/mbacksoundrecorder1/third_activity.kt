package com.example.mbacksoundrecorder1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_third.*

class third_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        val previewRequest = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val mydata = it.data
                val myuri= mydata?.data
                imgv_1.setImageURI(myuri)
                // do whatever with the data in the callback
            }
        }
    btn_3.setOnClickListener {
        Log.d("aaa","buton 3 e basıldı")

        val myintent1=Intent(Intent.ACTION_GET_CONTENT)
        myintent1.type="image/*"
        //startActivity(myintent1)
        previewRequest.launch(myintent1)
    }

    }

}
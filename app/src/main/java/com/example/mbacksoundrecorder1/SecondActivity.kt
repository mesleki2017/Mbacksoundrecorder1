package com.example.mbacksoundrecorder1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        btn_2.setOnClickListener {
            Intent(this,third_activity::class.java).also {
                startActivity(it)
            }
        }
    }

}
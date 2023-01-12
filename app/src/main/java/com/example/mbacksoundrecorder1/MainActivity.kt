package com.example.mbacksoundrecorder1

import android.Manifest
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ComponentActivity() {

    lateinit var receiver: AirplaneModeChangeReceiver


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.RECORD_AUDIO,Manifest.permission.CALL_PHONE
            ),
            0
        )
        setContentView(R.layout.activity_main)


        btn_start.setOnClickListener {
            Log.d("aaa","start butonuna basıldı")
            txtv_1.text="Start"

            Intent(applicationContext, MyService::class.java).apply {
                action = MyService.ACTION_START
                startService(this)
            }
        }

        btn_stop.setOnClickListener {
            txtv_1.text="Stop"
            Log.d("aaa","stop butonuna basıldı")
            Intent(applicationContext, MyService::class.java).apply {
                action = MyService.ACTION_STOP
                startService(this)
            }
        }

        btn_call.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL);
            intent.data = Uri.parse("tel:$4440000")
            startActivity(intent)
        }

        receiver = AirplaneModeChangeReceiver()

        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            // registering the receiver
            // it parameter which is passed in  registerReceiver() function
            // is the intent filter that we have just created
            registerReceiver(receiver, it)
        }

    }
    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}
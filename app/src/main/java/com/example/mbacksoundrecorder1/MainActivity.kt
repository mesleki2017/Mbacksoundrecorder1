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
import com.example.mbacksoundrecorder1.databinding.ActivityMainBinding



class MainActivity : ComponentActivity() {

    lateinit var receiver: AirplaneModeChangeReceiver
    private lateinit var binding: ActivityMainBinding//The 'kotlin-android-extensions' Gradle plugin is deprecated

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

        binding = ActivityMainBinding.inflate(layoutInflater)//The 'kotlin-android-extensions' Gradle plugin is deprecated
        setContentView(binding.root)//The 'kotlin-android-extensions' Gradle plugin is deprecated


        binding.btnStart.setOnClickListener {
            Log.d("aaa","start butonuna basıldı")
            binding.txtv1.text="Start"

            Intent(applicationContext, MyService::class.java).apply {
                action = MyService.ACTION_START
                startService(this)
            }
        }

        binding.btnStop.setOnClickListener {
            binding.txtv1.text="Stop"
            Log.d("aaa","stop butonuna basıldı")
            Intent(applicationContext, MyService::class.java).apply {
                action = MyService.ACTION_STOP
                startService(this)
            }
        }

        binding.btnCall.setOnClickListener {
            Log.d("aaa","call butonuna basıldı")
            Intent(applicationContext, MyService::class.java).apply {
                action = MyService.ACTION_CALL
                startService(this)
            }
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

    fun telAra(){
        val intent = Intent(Intent.ACTION_CALL);
        intent.data = Uri.parse("tel:$4440000")
        startActivity(intent)
    }
}
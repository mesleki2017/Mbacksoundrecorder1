package com.example.mbacksoundrecorder1

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mbacksoundrecorder1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var receiver: AirplaneModeChangeReceiver

    private lateinit var binding: ActivityMainBinding//The 'kotlin-android-extensions' Gradle plugin is deprecated

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)//The 'kotlin-android-extensions' Gradle plugin is deprecated
        setContentView(binding.root)//The 'kotlin-android-extensions' Gradle plugin is deprecated

        binding.bottomNavigationView.background=null//The 'kotlin-android-extensions' Gradle plugin is deprecated

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
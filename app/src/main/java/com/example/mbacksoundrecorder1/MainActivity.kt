package com.example.mbacksoundrecorder1

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.DocumentsContract.EXTRA_INITIAL_URI
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.core.app.ActivityCompat
import androidx.core.net.toUri
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.nio.file.Files


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
            val dd: File? = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
            if (dd != null) {
                Log.d("aaa getExternalFiles",dd.path)
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val paths =  Files.walk(dd?.toPath())
                    .forEach { item -> Log.d("aaa","filename: $item")}
            } else {
                Log.d("aaa internalDir ","hata")
            }

            val intent = Intent()
                .setType("*/*")
                .putExtra("android.provider.extra.INITIAL_URI", "ömhçjhkjhkjhlkuh")
                .setAction(Intent.ACTION_GET_CONTENT)



            startActivityForResult(Intent.createChooser(intent, "Select a file"), 111)


        }


    }
    override fun onStop() {
        super.onStop()

    }

}
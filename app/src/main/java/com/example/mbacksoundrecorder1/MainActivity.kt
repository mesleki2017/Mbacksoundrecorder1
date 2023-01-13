package com.example.mbacksoundrecorder1

import android.Manifest
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.storage.StorageManager
import android.provider.DocumentsContract
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.net.toUri
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : ComponentActivity() {

    lateinit var receiver: AirplaneModeChangeReceiver


    @RequiresApi(Build.VERSION_CODES.O)
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
            val mypath = filesDir
            Log.d("aaa mypath1 ",mypath.path )

            val intent = Intent()
                .setType("*/*")
                .setAction(Intent.ACTION_OPEN_DOCUMENT)
                .putExtra(DocumentsContract.EXTRA_INITIAL_URI, mypath.toURI())
            startActivityForResult(Intent.createChooser(intent, "Select a file"), 11)

            val intent1 = Intent(StorageManager.ACTION_MANAGE_STORAGE)
            //startActivity(intent1)

            val file = File(filesDir, "")
            Log.d("aaa mypath2 ",file.path)








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
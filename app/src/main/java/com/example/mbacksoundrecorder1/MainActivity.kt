package com.example.mbacksoundrecorder1

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
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
                Manifest.permission.RECORD_AUDIO,Manifest.permission.CALL_PHONE,Manifest.permission.READ_EXTERNAL_STORAGE
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

            val uri :Uri? = Uri.parse(dd?.toString())
            //https://stackoverflow.com/questions/21544331/trying-open-a-specific-folder-in-android-using-intent
            // bu koddan sonra mi acabildim tam eminde degilim
            // o kadar cok deneme yanilma yaptimki

            val intent = Intent()
                .setAction(Intent.ACTION_VIEW)//burasi gerekli
                .addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)//bunlar gereklimi emin degilim
                .addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)//bunlar gereklimi emin degilim
                .addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION)//bunlar gereklimi emin degilim
                .setDataAndType(uri, "resource/folder")//burasi gerekli
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

    fun telAra(){
        val intent = Intent(Intent.ACTION_CALL);
        intent.data = Uri.parse("tel:$4440000")
        startActivity(intent)
    }
}
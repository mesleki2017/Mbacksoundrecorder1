package com.example.mbacksoundrecorder1

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*



class MyService: Service(){

    private lateinit var armut:Mdefclient

    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onBind(p0: Intent?): IBinder? {
        Log.d("aaa","onBind ")
        return null
    }

    override fun onCreate() {
        super.onCreate()
        //elma.birfonksiyonInterfacedenGelen()
        armut=Mdefclient(3)
        //Log.d("aaa",elma.birdeger)// interface anlama
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action) {
            ACTION_START -> start()
            ACTION_STOP -> stop()
        }
        return super.onStartCommand(intent, flags, startId)
    }


    private fun start() {

        Log.d("aaa","start fonksiyonu calisti")
        Log.d("aaa", armut.benfonk().toString())
        armut.degisken1="portakal var"
        Log.d("aaa11 armut.degisken1", armut.degisken1)
        Log.d("aaa11 karesi", armut.karesi().toString())

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Log.d("aaa","Build.VERSION.SDK_INT")
            val  channel=NotificationChannel("deneme","deneme", NotificationManager.IMPORTANCE_LOW)
            getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
        }
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notification = NotificationCompat.Builder(this, "deneme")
            .setContentTitle("1111")
            .setContentText("22222")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setOngoing(true)



        val bbb = notification.setContentText("aaaaaa")
        notificationManager.notify(1, bbb.build())
        //startForeground(1, notification.build())
        notification.build()// bu olmadan notification gozukmuyor


        armut.flowdeneme()
            .catch {  e -> e.printStackTrace() }
            .onEach { Log.d("aaa","flow denemeler") }
            .launchIn(serviceScope)

        Log.d("aaa","start fonksiyonu sona geldi")
    }

    private fun stop() {
        Log.d("aaa","Myservice stop fonksiyonu calisti")
    }

    override fun onDestroy() {
        super.onDestroy()
    }



    companion object {
        const val ACTION_START = "ACTION_START"
        const val ACTION_STOP = "ACTION_STOP"
    }
}


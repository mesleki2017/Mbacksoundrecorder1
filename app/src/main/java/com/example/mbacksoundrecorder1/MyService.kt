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
    private  var elma = denemeinterface()
    private lateinit var armut:Mdefclient
    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    lateinit var flow: Flow<Int>//bu flow bakgroun locationda kullanılan flow tarzı değil

    override fun onBind(p0: Intent?): IBinder? {
        Log.d("aaa","onBind ")
        return null
    }

    override fun onCreate() {
        super.onCreate()
        setupFlow()
        //elma.birfonksiyonInterfacedenGelen()
        armut=Mdefclient()
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
        Log.d("aaa11", armut.degisken1)
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
        setupClicks()


        Log.d("aaa","start fonksiyonu sona geldi")
    }

    private fun stop() {
        Log.d("aaa","Myservice stop fonksiyonu calisti")
    }

    override fun onDestroy() {
        super.onDestroy()
    }


    private fun setupClicks() {
            CoroutineScope(Dispatchers.IO).launch {
                flow.collect {
                    Log.d("aaa", it.toString())
                }
            }
    }

    fun setupFlow(){
        flow = flow {
            Log.d("aaa", "Start flow")
            (0..3).forEach {
                // Emit items with 500 milliseconds delay
                delay(500)
                Log.d("aaa", "Emitting $it")
                emit(it)
            }
        }.flowOn(Dispatchers.IO)
    }

    companion object {
        const val ACTION_START = "ACTION_START"
        const val ACTION_STOP = "ACTION_STOP"
    }
}

// interface anlama
class  denemeinterface:Mclient {

}
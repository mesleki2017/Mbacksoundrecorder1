package com.example.mbacksoundrecorder1

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Binder
import android.os.Build
import android.os.Environment
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.mbacksoundrecorder1.databinding.ActivityMainBinding
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.io.File
import java.io.FileWriter
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class MyService: Service(){

    private lateinit var armut:Mdefclient

    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    private val mBinder: IBinder = MyBinder()

    public var sayi : Int=122

    class MyBinder : Binder() {
        val service: MyService
            get() = MyService()
    }

    override fun onBind(p0: Intent?): IBinder? {
        Log.d("aaa","onBind ")
        return mBinder
    }

    override fun onCreate() {
        super.onCreate()

        armut=Mdefclient(applicationContext,3)


    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action) {
            ACTION_START -> start()
            ACTION_STOP -> stop()
        }
        return START_STICKY
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
            .setContentTitle("Ses Seviyesi")
            .setContentText("---")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setOngoing(true)



        val bbb = notification.setContentText("aaaaaa")
        notificationManager.notify(1, bbb.build())
        //startForeground(1, notification.build())
        notification.build()// bu olmadan notification gozukmuyor


        armut.flowdeneme()
            .catch { Log.d("aaa22","catch calisti" )}
            .onEach {
                Log.d("aaa33","******onEach********" )
                Log.d("aaa12",it)
                val yenimesaj=notification.setContentText(it)
                notificationManager.notify(1, yenimesaj.build())
                notification.build()

                // tarih saat ekledim
                val currentTime: Date = Calendar.getInstance().getTime()
                val dateFormat: DateFormat = SimpleDateFormat("HH:mm:ss")
                val dateformatted: String = dateFormat.format(currentTime)
                // text dosyasina yazma ekledim
                textDosyasiYaz(dateformatted+","+it+"\n");
            }
            .launchIn(serviceScope)

        startForeground(1, notification.build())
        Log.d("aaa","start fonksiyonu sona geldi")
    }

    private fun stop() {
        Log.d("aaa","Myservice stop fonksiyonu calisti")
        stopForeground(true)
        armut.jobAA.cancel()//while loop taki job u cancel ediyor. baska yolunu bulamadım
        armut.mRecorder!!.stop()
        stopSelf()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private  fun textDosyasiYaz(dataGir:String){
        val dd: File? = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
        val file = File(dd, "ses444.txt")
        val writer = FileWriter(file, true)
        writer.append(dataGir)
        writer.close()
    }

    fun getRandomNumber(): String? {
        return sayi.toString()
    }
    companion object {
        const val ACTION_START = "ACTION_START"
        const val ACTION_STOP = "ACTION_STOP"
        const val ACTION_CALL = "ACTION_CALL"
    }
}


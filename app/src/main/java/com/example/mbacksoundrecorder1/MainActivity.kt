package com.example.mbacksoundrecorder1

import android.Manifest
import android.content.*
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.core.app.ActivityCompat
import com.example.mbacksoundrecorder1.databinding.ActivityMainBinding
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.coroutines.*
import java.util.ArrayList


class MainActivity : ComponentActivity() {

    lateinit var receiver: AirplaneModeChangeReceiver
    private lateinit var binding: ActivityMainBinding//The 'kotlin-android-extensions' Gradle plugin is deprecated
    private  var ddd:Int = 0

    var myBoundMyService: MyService? = null
    var mServiceBound = false
    private var jobAA: Job = Job()// corutine jobu
    private val scopeAA = MainScope()//

    private val mServiceConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName, binder: IBinder) {
            myBoundMyService = (binder as MyService.MyBinder).service
            Log.d("aaServiceConnection", "connected")
            mServiceBound = true
        }

        override fun onServiceDisconnected(name: ComponentName) {
            mServiceBound = false
        }
    }

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


        val intent1 = Intent(this, MyService::class.java).also { it.putExtra("ccc","bu mainden servise gelen") }
        bindService(intent1, mServiceConnection, Context.BIND_AUTO_CREATE);

        binding = ActivityMainBinding.inflate(layoutInflater)//The 'kotlin-android-extensions' Gradle plugin is deprecated
        setContentView(binding.root)//The 'kotlin-android-extensions' Gradle plugin is deprecated


        binding.btnStart.setOnClickListener {
            Log.d("aaa","start butonuna basıldı")
            binding.txtv1.text="Start"
            Intent(applicationContext, MyService::class.java).apply {
                action = MyService.ACTION_START
                startService(this)
                //setLineChartData(it.toFloat())
            }
            birsey_yap()
        }

        binding.btnStop.setOnClickListener {
            binding.txtv1.text="Stop"
            Log.d("aaa","stop butonuna basıldı")
            Intent(applicationContext, MyService::class.java).apply {
                action = MyService.ACTION_STOP
                startService(this)
            }
            birsey_durdur()
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
            registerReceiver(receiver, it)
        }

    }

    val linevalues = ArrayList<Entry>()
    fun setLineChartData(deger1:Float) {

        linevalues.add(Entry(deger1, deger1))

        val linedataset = LineDataSet(linevalues, "First")
        //We add features to our chart
        linedataset.color = resources.getColor(R.color.purple_200)

        linedataset.circleRadius = 10f
        linedataset.setDrawFilled(true)
        linedataset.valueTextSize = 20F
        linedataset.fillColor = resources.getColor(androidx.appcompat.R.color.material_blue_grey_800)
        linedataset.setMode(LineDataSet.Mode.CUBIC_BEZIER);

        //We connect our data to the UI Screen
        val data = LineData(linedataset)
        binding.getTheGraph.data = data
        binding.getTheGraph.setBackgroundColor(resources.getColor(R.color.white))
        binding.getTheGraph.animateXY(2000, 2000, Easing.EaseInCubic)

    }

    private fun birsey_yap(){
        jobAA = scopeAA.launch(Dispatchers.IO) {

            while (isActive) {
                withContext(Dispatchers.Main){
                    val aa11=myBoundMyService?.getRandomNumber()
                    Log.d("aaa55", aa11.toString())

                }
                delay(1000L)// delay sadece corutine icinde kullaniliyormus
            }
        }
    }

    private fun  birsey_durdur(){
        jobAA.cancel()
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }

}
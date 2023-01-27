package com.example.mbacksoundrecorder1

import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mbacksoundrecorder1.databinding.ActivityMainBinding
import io.github.farshidroohi.ChartEntity
import io.github.farshidroohi.LineChart

class MainActivity : AppCompatActivity() {

    lateinit var receiver: AirplaneModeChangeReceiver

    private lateinit var binding: ActivityMainBinding//The 'kotlin-android-extensions' Gradle plugin is deprecated
    private var graph2 =
        floatArrayOf(0f, 245000f, 1011000f, 1000f, 0f, 0f, 47000f, 20000f, 12000f, 124400f, 160000f)
    private var graph1 =
        floatArrayOf(0f, 245000f, 1011000f, 1000f, 0f, 0f, 47000f, 20000f, 12000f, 124400f, 160000f)
    private var legendArr = arrayListOf(
        "05/21",
        "05/22",
        "05/23",
        "05/24",
        "05/25",
        "05/26",
        "05/27",
        "05/28",
        "05/29",
        "05/30",
        "05/31"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstChartEntity = ChartEntity(Color.WHITE, graph1)
        val secondChartEntity = ChartEntity(Color.YELLOW, graph2)
        val list = ArrayList<ChartEntity>().apply {
            add(firstChartEntity)
            add(secondChartEntity)
        }
        val lineChart = findViewById<LineChart>(R.id.lineChart)
        lineChart.setLegend(legendArr)
        lineChart.setList(list)



        binding = ActivityMainBinding.inflate(layoutInflater)//The 'kotlin-android-extensions' Gradle plugin is deprecated
        setContentView(binding.root)//The 'kotlin-android-extensions' Gradle plugin is deprecated


        val myNav=binding.bottomNavigationView
        myNav.background=null//The 'kotlin-android-extensions' Gradle plugin is deprecated

        myNav.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.mySearch-> {
                    Log.d("aaa","mySerach e basildi")
                    true
                }
                R.id.myAdd-> {
                    Log.d("aaa","myAdd e basildi")
                    true
                }
                R.id.mySettings-> {
                    Log.d("aaa","mySettings e basildi")
                    true
                }
                R.id.myperson-> {
                    Log.d("aaa","myperson e basildi")
                    true
                }
                else -> {
                    Log.d("aaa","mySerach else calisti")
                    false}
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
}
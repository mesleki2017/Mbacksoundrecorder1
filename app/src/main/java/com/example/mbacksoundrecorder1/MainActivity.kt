package com.example.mbacksoundrecorder1

import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color.green
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

import com.example.mbacksoundrecorder1.databinding.ActivityMainBinding
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet


class MainActivity : AppCompatActivity() {

    lateinit var receiver: AirplaneModeChangeReceiver

    private lateinit var binding: ActivityMainBinding//The 'kotlin-android-extensions' Gradle plugin is deprecated
    private  var ddd:Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)//The 'kotlin-android-extensions' Gradle plugin is deprecated
        setContentView(binding.root)//The 'kotlin-android-extensions' Gradle plugin is deprecated

        setLineChartData()

        //binding.bottomNavigationView.background=null//The 'kotlin-android-extensions' Gradle plugin is deprecated
        val bottomNav=binding.bottomNavigationView
        bottomNav.background=null

        bottomNav.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.mySearch-> {
                    Log.d("aaa","mySerach e basildi")
                    showDefaultDialog2("mySerach e basildi")
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



        binding.btn23.setOnClickListener {
            Log.d("aaa","butona basildi")
            ddd += 1
            showDefaultDialog(ddd.toString())
        }


        receiver = AirplaneModeChangeReceiver()

        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            // registering the receiver
            // it parameter which is passed in  registerReceiver() function
            // is the intent filter that we have just created
            registerReceiver(receiver, it)
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu)
        //menuInflater.inflate(R.menu.bottom_nav_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.red-> {
                Log.d("aaa","red secildi")
                item.isChecked = !item.isChecked
                true
            }
            R.id.blue-> {
                Log.d("aaa","blue secildi")
                item.isChecked = !item.isChecked
                true
            }
            else -> super.onOptionsItemSelected(item)


        }
    }

    //https://www.section.io/engineering-education/getting-started-with-dialogs-in-android-kotlin/
    private fun showDefaultDialog(aaa:String) {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.apply {
            setTitle("Sayi Sayma")
            setMessage(aaa)
            setNegativeButton("sifirla"){_,_->ddd=0}
        }.create().show()
    }

    private fun showDefaultDialog2(aaa:String) {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.apply {
            setTitle("bottom nav dan")
            setMessage(aaa)
        }.create().show()
    }

    fun setLineChartData() {

        val linevalues = ArrayList<Entry>()
        linevalues.add(Entry(20f, 0.0F))
        linevalues.add(Entry(30f, 3.0F))
        linevalues.add(Entry(40f, 2.0F))
        linevalues.add(Entry(50f, 1.0F))
        linevalues.add(Entry(60f, 8.0F))
        linevalues.add(Entry(70f, 10.0F))
        linevalues.add(Entry(80f, 1.0F))
        linevalues.add(Entry(90f, 2.0F))
        linevalues.add(Entry(100f, 5.0F))
        linevalues.add(Entry(110f, 1.0F))
        linevalues.add(Entry(120f, 20.0F))
        linevalues.add(Entry(130f, 40.0F))
        linevalues.add(Entry(140f, 50.0F))

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

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}
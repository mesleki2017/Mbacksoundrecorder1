package com.example.mbacksoundrecorder1

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import com.example.mbacksoundrecorder1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var receiver: AirplaneModeChangeReceiver

    private lateinit var binding: ActivityMainBinding//The 'kotlin-android-extensions' Gradle plugin is deprecated
    private  var ddd:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)//The 'kotlin-android-extensions' Gradle plugin is deprecated
        setContentView(binding.root)//The 'kotlin-android-extensions' Gradle plugin is deprecated

        binding.bottomNavigationView.background=null//The 'kotlin-android-extensions' Gradle plugin is deprecated


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

    private fun showDefaultDialog(aaa:String) {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.apply {
            setTitle(aaa)
        }.create().show()
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}
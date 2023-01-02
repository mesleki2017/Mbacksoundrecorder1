package com.example.mbacksoundrecorder1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log


class AirplaneModeChangeReceiver : BroadcastReceiver() {

    override fun onReceive(contxt: Context?, intent: Intent?) {
        Log.d("aaa","onRecive")
        val isAirplaneModeEnabled = intent?.getBooleanExtra("state", false) ?: return

        if (isAirplaneModeEnabled) {
            Log.d("aaa","Airplane Mode Enabled")
        }else{
            Log.d("aaa","onRecive")
        }

    }

}
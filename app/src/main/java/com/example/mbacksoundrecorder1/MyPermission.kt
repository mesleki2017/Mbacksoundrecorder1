package com.example.mbacksoundrecorder1

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.content.ContextCompat

fun Context.myPermissionAl(): Boolean {
    val aaa=ContextCompat.checkSelfPermission(
        this,
        Manifest.permission.RECORD_AUDIO
    )
    Log.d("aaa checkSelfPermission",aaa.toString())
    Log.d("aaa PERMISSION_GRANTED",PackageManager.PERMISSION_GRANTED.toString())
    return ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.RECORD_AUDIO
            ) == PackageManager.PERMISSION_GRANTED
}
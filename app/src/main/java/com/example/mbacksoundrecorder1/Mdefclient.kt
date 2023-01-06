package com.example.mbacksoundrecorder1

import android.annotation.SuppressLint
import android.content.Context
import android.os.Looper
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow



class Mdefclient(
    private val context: Context,
    override val birdeger: Int) : Mclient {
    var degisken1 : String = " elma yok "
    var degisken2 : Int = 0


    fun benfonk(){
        Log.d("aaa","mdefclient teki fonksiyon calisti // " + degisken1)
    }


    @SuppressLint("MissingPermission")
    override fun flowdeneme(): Flow<String> {

        return callbackFlow {
            if(!context.myPermissionAl()) {
                Log.d("aaa","Missing  permission")
            }else{Log.d("aaa","OK permission")}

            degisken2 += 1
            Log.d("aaa"," **********flow")
            launch{
                Log.d("aaa"," ********** flow launch")
                send(degisken2.toString())
            }
            awaitClose {Log.d("aaa"," **********awaitClose")}
            // awaitclose yazımca her seferinde send deki datayı gönderdi MyService e
        }

    }
}

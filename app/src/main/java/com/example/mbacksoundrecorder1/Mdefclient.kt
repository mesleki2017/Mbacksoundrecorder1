package com.example.mbacksoundrecorder1

import android.os.Looper
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow


class Mdefclient(override val birdeger: Int) : Mclient {
    var degisken1 : String = " elma yok "

    fun benfonk(){
        Log.d("aaa","mdefclient teki fonksiyon calisti // " + degisken1)
    }



    override fun flowdeneme(): Flow<String> {
        return callbackFlow {
            Log.d("aaa"," **********flow")

            launch{
                Log.d("aaa"," ********** flow launch")
                send(" flow launch dan send edilen")
            }

        }
        //Looper.getMainLooper()
    }
}
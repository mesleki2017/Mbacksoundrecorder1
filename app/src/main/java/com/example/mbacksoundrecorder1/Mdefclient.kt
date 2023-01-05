package com.example.mbacksoundrecorder1

import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow


class Mdefclient(override val birdeger: Int) : Mclient {
    var degisken1 : String = " elma yok "

    fun benfonk(){
        Log.d("aaa","mdefclient teki fonksiyon calisti // " + degisken1)
    }

    override fun flowdeneme(): Flow<Int> {
        return callbackFlow {
            Log.d("aaa"," **********flow")
            (50..53).forEach {
                // Emit items with 500 milliseconds delay
                delay(500)
                Log.d("aaa", "Emitting $it")

            }
        }
    }
}
package com.example.mbacksoundrecorder1

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


interface Mclient {

    val birdeger: Int

    fun karesi(): Int {
        var kkk=birdeger*birdeger
        Log.d("aaa",kkk.toString())
        return birdeger*birdeger
    }

    fun birfonksiyonInterfacedenGelen(){
        Log.d("aaa","interface deki fonksion calisti")
    }

}


//background location progrmaindaki flow mantığını anlamaya calisiyorum.




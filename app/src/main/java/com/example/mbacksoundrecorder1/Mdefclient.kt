package com.example.mbacksoundrecorder1

import android.annotation.SuppressLint
import android.content.Context
import android.media.MediaRecorder
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
    private var mRecorder: MediaRecorder? = null
    var jobAA: Job = Job()

    fun benfonk(){
        Log.d("aaa","mRecorder --->" + mRecorder)
        if (mRecorder == null) {
        mRecorder= MediaRecorder().apply {
            setAudioSource(MediaRecorder.AudioSource.MIC)
            setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            setOutputFile("/dev/null")
            setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
        }}
        try {
            mRecorder!!.prepare()
        }catch (e:Exception){Log.d("aaa mRecorder","mRecorder prepare de hata")}
    }


    @SuppressLint("MissingPermission")
    override fun flowdeneme(): Flow<String> {

        return callbackFlow {
            if(!context.myPermissionAl()) {
                Log.d("aaa permission","Missing  permission")
            }else{Log.d("aaa permission","OK permission")}

            try {
                // mediarecorder start hata veriyordu  start butonuna 2. defa bastığımda
                // asagidki if sorgusunu ekledim ise yariyormu test ediyorum
                mRecorder!!.start()
            }catch (e:Exception){
                Log.d("aaa mRecorder", e.toString())
                //mRecorder!!.stop()
            }


            Log.d("aaa"," **********flow")
            jobAA = launch{
                while (isActive) {//flow u dongusek hale getirme calismasi yapıyorum
                    //degisken2 = mRecorder!!.maxAmplitude
                    degisken2=degisken2+1
                    Log.d("aaa ses seviye", mRecorder!!.maxAmplitude.toString())
                    send(degisken2.toString())
                    delay(1000L)
                }

            }
            awaitClose {
                Log.d("aaa"," **********awaitClose")
                jobAA.cancel()
                mRecorder!!.stop()
            }
            // awaitclose yazımca her seferinde send deki datayı gönderdi MyService e
        }

    }
}

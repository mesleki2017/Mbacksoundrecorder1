package com.example.mbacksoundrecorder1

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log
import androidx.core.content.getSystemService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


interface Mclient {
    //buraya bir flow eklemek istiyorum

    val birdeger: Int

    fun karesi(): Int {
        var kkk=birdeger*birdeger
        Log.d("aaa",kkk.toString())
        return birdeger*birdeger
    }

    fun birfonksiyonInterfacedenGelen(){
        Log.d("aaa","interface deki fonksion calisti")
    }

    fun flowdeneme():Flow<String>

    class MySensor(private val context: Context): SensorEventListener {
        lateinit var sensorManager: SensorManager
        private lateinit var gsensor: Sensor
        private val mGravity = FloatArray(3)

        fun sensorAyar(){
            sensorManager=context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
            gsensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        }

        fun start(){
            sensorManager.registerListener(this, gsensor,
                SensorManager.SENSOR_DELAY_GAME)

        }

        override fun onSensorChanged(event: SensorEvent?) {
            if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {
                mGravity[0]=event.values[0]
                mGravity[1]=event.values[1]
                mGravity[2]=event.values[2]
                Log.d("aaa sensor", event.values[0].toString())
            }
        }

        override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
            Log.d("aaa","onAccuracyChanged")
        }
    }


}


//background location progrmaindaki flow mantığını anlamaya calisiyorum.




package com.example.mbacksoundrecorder1

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log
import kotlinx.coroutines.flow.Flow


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
        var myAccelero = FloatArray(3)

        fun sensorAyar(){
            sensorManager=context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
            gsensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        }

        fun start(){
            sensorManager.registerListener(this, gsensor,
                SensorManager.SENSOR_DELAY_GAME)

        }
        fun stop(){
            sensorManager.unregisterListener(this)
        }

        override fun onSensorChanged(event: SensorEvent?) {
            if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {
                myAccelero[0]=event.values[0]
                myAccelero[1]=event.values[1]
                myAccelero[2]=event.values[2]
                //Log.d("aaa sensor", mGravity[0].toString())
            }
        }

        override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
            Log.d("aaa","onAccuracyChanged")
        }
    }


}


//background location progrmaindaki flow mantığını anlamaya calisiyorum.




package com.example.ht1

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.widget.Toast
import kotlin.random.Random

class ExampleService : Service() {

    private lateinit var mHandler: Handler
    private lateinit var mRunnable: Runnable

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }


    //запуск сервиса
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "Service started", Toast.LENGTH_SHORT).show()

        mHandler = Handler()
        mRunnable = Runnable { showToast() }
        mHandler.postDelayed(mRunnable, 1000)

        return START_STICKY
    }


    //остановка сервиса
    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Service destroyed", Toast.LENGTH_SHORT).show()
        mHandler.removeCallbacks(mRunnable)
    }

    private fun showToast(){
        Toast.makeText(this, "Service is still running", Toast.LENGTH_SHORT).show()
        mHandler.postDelayed(mRunnable, 1000)
    }
}
package com.example.ht1

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ht1.databinding.ActivityServiceBinding

private lateinit var binding: ActivityServiceBinding

class ServiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityServiceBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = Intent(this, ExampleService::class.java)


        //ЖЦ у сервиса дольше, чем у активити, в котором он был запущен
        //после унижтожения этого активити сервис продолжит свою работу

            //запуск сервиса
        binding.StartButton.setOnClickListener {
            //проверяем, не запущен ли он уже
            if (!isServiceRunning(ExampleService::class.java))
                startService(intent)
            else
                Toast.makeText(this, "Already started", Toast.LENGTH_SHORT).show()

            //остановка сервиса
            binding.StopButton.setOnClickListener {
                stopService(intent)
            }
        }


    }

    //функция проверки состояния сервиса
    private fun isServiceRunning(serviceClass: Class<*>): Boolean {
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        for (service in activityManager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.name == service.service.className) {
                return true
            }
        }
        return false
    }
}
package com.example.ht1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ht1.databinding.ActivityReceiverBinding

private lateinit var binding: ActivityReceiverBinding

class ReceiverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReceiverBinding.inflate(layoutInflater)
        setContentView(binding.root)



        //на каждое нажатие кнопки шлем интент с соответствующим сообщением
        //у интента нет явного адресата
        //эти интенты могут быть отловлены вне данного активити при помощи получателя
        binding.button1.setOnClickListener {
            val intent = Intent("button_clicked")
            intent.putExtra("button num", 1)
            sendBroadcast(intent)
        }
        binding.button2.setOnClickListener {
            val intent = Intent("button_clicked")
            intent.putExtra("button num", 2)
            sendBroadcast(intent)
        }
        binding.button3.setOnClickListener {
            val intent = Intent("button_clicked")
            intent.putExtra("button num", 3)
            sendBroadcast(intent)

        }
        binding.button4.setOnClickListener {
            val intent = Intent("button_clicked")
            intent.putExtra("button num", 4)
            sendBroadcast(intent)

        }
        binding.button5.setOnClickListener {
            val intent = Intent("button_clicked")
            intent.putExtra("button num", 5)
            sendBroadcast(intent)

        }
    }
}
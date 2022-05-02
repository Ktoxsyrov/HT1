package com.example.ht1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ht1.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()


        binding.providerButton.setOnClickListener {
           val intent = Intent(this, ProviderActivity::class.java)
            startActivity(intent)
        }

        binding.receiverButton.setOnClickListener {
            val intent = Intent(this, ReceiverActivity::class.java)
            startActivity(intent)
        }

        binding.serviceButton.setOnClickListener {
            val intent = Intent(this, ServiceActivity::class.java)
            startActivity(intent)
        }
    }

}
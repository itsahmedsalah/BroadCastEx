package com.example.broadcastex

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.example.broadcastex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // Make variable from the receiver
    private val myBroadCast = MyBroadCast()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Register the Receiver and filter the action that you are looking for
        registerReceiver(myBroadCast, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))


    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myBroadCast)
    }
}
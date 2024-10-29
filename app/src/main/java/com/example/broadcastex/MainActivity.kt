package com.example.broadcastex

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.broadcastex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myBroadCast = MyBroadCast()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerReceiver(myBroadCast, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}
package com.example.broadcastex

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.widget.Toast

class MyBroadCast : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val isTurnedOn = Settings.Global.getInt(
            context?.contentResolver,
            Settings.Global.AIRPLANE_MODE_ON
        ) != 0
        val x = if (isTurnedOn) "On" else "Off"
        Toast.makeText(context, "AirPlane mode is $x", Toast.LENGTH_LONG).show()

    }
}
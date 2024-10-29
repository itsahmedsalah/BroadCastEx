package com.example.broadcastex

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.widget.Toast

// The Receiver class that do the action

class MyBroadCast : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val isTurnedOn = Settings.Global.getInt(
            context?.contentResolver,
            Settings.Global.AIRPLANE_MODE_ON
        ) != 0
        var x = if (isTurnedOn) "On" else "Off"
        Toast.makeText(context, "${intent!!.action}", Toast.LENGTH_LONG).show()

    }
}
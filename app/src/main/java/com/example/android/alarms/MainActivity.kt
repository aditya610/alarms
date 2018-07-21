package com.example.android.alarms

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val am = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, myservice::class.java)
        val pi = PendingIntent.getService(
                this,
                111,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT
        )
        button.setOnClickListener({
        am.setExact(
                AlarmManager.ELAPSED_REALTIME,
                SystemClock.elapsedRealtime()+(1000*10),
                pi
        )})
        btnstop.setOnClickListener({
            stopService(intent)
        })
    }
}

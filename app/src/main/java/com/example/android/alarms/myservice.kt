package com.example.android.alarms

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class myservice:Service() {

val tag="src"
    var starcount=0
    override fun onCreate() {
        Log.d(tag,"oncreate")
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

    Log.d(tag,"onstar${++starcount}")
        val stattime=System.currentTimeMillis()
        while (System.currentTimeMillis()<stattime+10000);
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        Log.d(tag,"ondestroy")
        super.onDestroy()
    }



    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
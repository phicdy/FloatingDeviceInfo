package com.phicdy.floatingdeviceinfo

import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.os.Build
import android.os.IBinder
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager

class FloatingDeviceInfoService : Service() {

    private lateinit var wm: WindowManager
    private lateinit var view: View
    private lateinit var params: WindowManager.LayoutParams

    override fun onCreate() {
        super.onCreate()
        showOverlayView()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        hideOverlayView()
        showOverlayView()
        return super.onStartCommand(intent, flags, startId)
    }

    private fun showOverlayView() {
        val layoutInflater = LayoutInflater.from(this)
        params = WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
                else WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE or
                        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT)
        params.gravity = Gravity.TOP or Gravity.START
        params.x = 0
        params.y = 124
        wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        view = layoutInflater.inflate(R.layout.overlay, null)
        wm.addView(view, params)
    }

    private fun hideOverlayView() {
        wm.removeView(view)
    }

    override fun onDestroy() {
        super.onDestroy()
        hideOverlayView()
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}

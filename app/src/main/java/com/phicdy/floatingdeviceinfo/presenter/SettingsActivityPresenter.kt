package com.phicdy.floatingdeviceinfo.presenter

import android.content.Context
import com.phicdy.floatingdeviceinfo.model.PermissionCheck
import com.phicdy.floatingdeviceinfo.view.activity.SettingsView

class SettingsActivityPresenter(private val view: SettingsView) : Presenter {


    override fun onCreate() {
        view.setupActionBar()
    }

    fun onStartPermissionCheck(context: Context) {
        if (PermissionCheck.isSystemOverlayEnabled(context)) {
            view.startFloatingDeviceInfoService()
        } else {
            view.openSystemAlertSetting()
        }
    }

    override fun onResume() {
        view.startPermissionCheck()
    }

    override fun onPause() {
    }
}
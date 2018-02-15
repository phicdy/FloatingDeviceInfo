package com.phicdy.floatingdeviceinfo.presenter

import com.phicdy.floatingdeviceinfo.view.activity.SettingsView

class SettingsActivityPresenter(private val view: SettingsView) : Presenter {


    override fun onCreate() {
        view.setupActionBar()
        view.startFloatingDeviceInfoService()
    }

    override fun onResume() {
    }

    override fun onPause() {
    }
}
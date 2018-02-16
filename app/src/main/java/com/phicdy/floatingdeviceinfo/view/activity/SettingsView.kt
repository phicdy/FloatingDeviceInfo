package com.phicdy.floatingdeviceinfo.view.activity

interface SettingsView {
    fun setupActionBar()
    fun startFloatingDeviceInfoService()
    fun startPermissionCheck()
    fun openSystemAlertSetting()
}
package com.goldpalm.emergencyinquiry.app

import android.app.Application
import com.goldpalm.emergencyinquiry.util.ActivityUtil

class App : Application(){
   lateinit var app:App
    override fun onCreate() {
        super.onCreate()
        if (null==app){
            app=this
        }

        ActivityUtil.init(this)
    }

    fun getInstance() : App {
        return app
    }

}
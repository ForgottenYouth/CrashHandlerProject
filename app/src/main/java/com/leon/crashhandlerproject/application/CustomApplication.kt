/*
* FileName: CustomApplication
* Author: shiwenliang
* Date: 2020/9/18 16:17
* Description: 自定义的application
*/
package com.leon.crashhandlerproject.application

import android.app.Application
import com.leon.crashhandlerproject.CrashHandler
import com.leon.crashhandlerproject.CrashHandlerCallBack

class CustomApplication :Application(){
    override fun onCreate() {
        super.onCreate()
        
        /*
        * TODO 在自定义的application中进行注册初始化
        */
        CrashHandler.getInstance().init(object : CrashHandlerCallBack {
            override fun onCrashUncaughtHappenCallBack(t: Thread, e: Throwable) {

            }
        })
    }
}
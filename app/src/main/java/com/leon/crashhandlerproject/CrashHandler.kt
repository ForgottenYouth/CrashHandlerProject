/*
* FileName: CrashHandler
* Author: shiwenliang
* Date: 2020/9/18 15:18
* Description: 异常捕获的工具
*/
package com.leon.crashhandlerproject

import android.os.Process
import kotlin.system.exitProcess

class CrashHandler() : Thread.UncaughtExceptionHandler {

    /*
    * TODO 异常回调
    */
    lateinit var mCallBack:CrashHandlerCallBack

    /*
    * TODO 做初始化工作
    */
    fun init(callBack: CrashHandlerCallBack){
        mCallBack = callBack
        Thread.setDefaultUncaughtExceptionHandler(this)
    }


    /*
    * TODO 伴生对象  类似于static
    */
    companion object{
        private lateinit var mInstance : CrashHandler
        fun getInstance():CrashHandler{
            return mInstance
        }
    }

    /*
    * TODO 继承回调，并将捕获到的异常转交到新的线程中执行不同的处理
    */
    override fun uncaughtException(t: Thread, e: Throwable) {

        /*
        * TODO 捕获异常处理
        */
        handleuncaughtException(t,e)
        Process.killProcess(Process.myPid())
        exitProcess(1)
    }

    /*
    * TODO 此处处理异常
    *   1.可以操作写入log
    *   2.可以弹出友好的页面
    *   3.可以将日志上传到服务器中
    */
    private fun handleuncaughtException(t:Thread,e:Throwable){
        Thread(Runnable { kotlin.run {
            mCallBack.onCrashUncaughtHappenCallBack(t,e)
        } }).start()
    }

}

/*
* TODO 捕获到异常后的回调
*/
interface CrashHandlerCallBack{
    fun onCrashUncaughtHappenCallBack(t:Thread,e:Throwable)
}
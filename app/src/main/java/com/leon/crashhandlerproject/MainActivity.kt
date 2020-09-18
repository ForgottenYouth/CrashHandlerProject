package com.leon.crashhandlerproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        if (view.id==R.id.exception){

        }
    }
}
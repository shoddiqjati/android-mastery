package com.example.jati.practices.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.jati.practices.PracticesApp
import com.example.jati.practices.di.components.AppComponent

/**
 * Created by Jati on 16/08/18.
 */

abstract class BaseActivity : AppCompatActivity() {

    val appComponent: AppComponent by lazy {
        (application as PracticesApp).appComponent
    }

    abstract val layout: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)

        inject()
        onUiLoaded()
    }

    abstract fun inject()

    abstract fun onUiLoaded()
}
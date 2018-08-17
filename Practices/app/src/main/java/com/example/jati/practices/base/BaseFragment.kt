package com.example.jati.practices.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jati.practices.PracticesApp
import com.example.jati.practices.di.components.AppComponent

/**
 * Created by Jati on 16/08/18.
 */

abstract class BaseFragment : Fragment() {

    protected val appComponent: AppComponent by lazy {
        (activity?.application as PracticesApp).appComponent
    }

    abstract val layout: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inject()
        onUiLoaded()
    }

    abstract fun inject()

    abstract fun onUiLoaded()
}
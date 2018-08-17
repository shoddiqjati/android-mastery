package com.example.jati.practices.ui.settings

import android.os.Bundle
import com.example.jati.practices.R
import com.example.jati.practices.base.BaseFragment

/**
 * Created by Jati on 17/08/18.
 */

class SettingsFragment : BaseFragment() {

    companion object {
        @JvmStatic
        fun newInstance(): SettingsFragment {
            val settingsFragment = SettingsFragment()
            val args = Bundle()
            settingsFragment.arguments = args
            return settingsFragment
        }
    }

    override val layout = R.layout.fragment_settings

    override fun inject() {

    }

    override fun onUiLoaded() {

    }
}
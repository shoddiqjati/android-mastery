package com.example.jati.practices.ui

import android.annotation.SuppressLint
import android.support.design.internal.BottomNavigationItemView
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import com.example.jati.practices.R
import com.example.jati.practices.base.BaseActivity
import com.example.jati.practices.ui.history.HistoryFragment
import com.example.jati.practices.ui.order.OrderFragment
import com.example.jati.practices.ui.settings.SettingsFragment
import com.example.jati.practices.ui.wallet.WalletFragment
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber.d

class MainActivity : BaseActivity() {

    override val layout = R.layout.activity_main

    override fun inject() {
        appComponent.inject(this)
    }

    override fun onUiLoaded() {
        bottom_nav.setOnNavigationItemSelectedListener(navigationSelectedListener)
        bottom_nav.selectedItemId = R.id.nav_history
        removeShiftMode(bottom_nav)
    }

    private fun selectFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private val navigationSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when (it.itemId) {
            R.id.nav_history -> {
                selectFragment(HistoryFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_order -> {
                selectFragment(OrderFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_wallet -> {
                selectFragment(WalletFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_settings -> {
                selectFragment(SettingsFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    @SuppressLint("RestrictedApi")
    private fun removeShiftMode(bottomNavigationView: BottomNavigationView) {
        val menuView = bottomNavigationView.getChildAt(0) as BottomNavigationMenuView
        try {
            val shiftingMode = menuView.javaClass.getDeclaredField("mShiftingMode")
            shiftingMode.isAccessible = true
            shiftingMode.setBoolean(menuView, false)
            shiftingMode.isAccessible = false
            for (i in 0 until menuView.childCount) {
                val item = menuView.getChildAt(i) as BottomNavigationItemView
                item.setShiftingMode(false)
                item.setChecked(item.itemData.isChecked)
            }
        } catch (e: NoSuchFieldException) {
            d(e)
        } catch (e: IllegalAccessException) {
            d(e)
        }
    }
}

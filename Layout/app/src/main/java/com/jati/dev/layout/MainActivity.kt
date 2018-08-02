package com.jati.dev.layout

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.jati.dev.layout.section.history.HistoryFragment
import com.jati.dev.layout.section.MyWalletFragment
import com.jati.dev.layout.section.OrderFragment
import com.jati.dev.layout.section.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*
import android.support.design.widget.BottomNavigationView
import android.support.design.internal.BottomNavigationItemView
import android.support.design.internal.BottomNavigationMenuView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUiComponents()
    }

    private fun initUiComponents() {
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
                selectFragment(MyWalletFragment.newInstance())
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
        val menuView: BottomNavigationMenuView = bottomNavigationView.getChildAt(0) as BottomNavigationMenuView
        val shiftingMode = menuView.javaClass.getDeclaredField("mShiftingMode")
        shiftingMode.isAccessible = true
        shiftingMode.setBoolean(menuView, false)
        shiftingMode.isAccessible = false
        for (i in 0 until menuView.childCount) {
            val item = menuView.getChildAt(i) as BottomNavigationItemView
            item.setShiftingMode(false)
            item.setChecked(item.itemData.isChecked)
        }
    }
}

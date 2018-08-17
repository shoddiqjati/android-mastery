package com.example.jati.practices.ui.order

import android.os.Bundle
import com.example.jati.practices.R
import com.example.jati.practices.base.BaseFragment

/**
 * Created by Jati on 17/08/18.
 */

class OrderFragment : BaseFragment() {

    companion object {
        @JvmStatic
        fun newInstance(): OrderFragment {
            val orderFragment = OrderFragment()
            val args = Bundle()
            orderFragment.arguments = args
            return orderFragment
        }
    }

    override val layout = R.layout.fragment_order

    override fun inject() {

    }

    override fun onUiLoaded() {

    }
}
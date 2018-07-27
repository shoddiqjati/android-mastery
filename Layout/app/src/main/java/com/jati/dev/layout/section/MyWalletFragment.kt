package com.jati.dev.layout.section

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.jati.dev.layout.R

class MyWalletFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_my_wallet, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = MyWalletFragment().apply {}
    }
}

package com.example.jati.practices.ui.wallet

import android.os.Bundle
import com.example.jati.practices.R
import com.example.jati.practices.base.BaseFragment

/**
 * Created by Jati on 17/08/18.
 */

class WalletFragment : BaseFragment() {

    companion object {
        @JvmStatic
        fun newInstance(): WalletFragment {
            val walletFragment = WalletFragment()
            val args = Bundle()
            walletFragment.arguments = args
            return walletFragment
        }
    }

    override val layout = R.layout.fragment_my_wallet

    override fun inject() {

    }

    override fun onUiLoaded() {

    }
}
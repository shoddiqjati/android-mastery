package com.example.jati.practices.ui.history

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.jati.practices.R
import com.example.jati.practices.base.BaseFragment
import com.example.jati.practices.entity.model.History
import com.jati.dev.layout.utils.Constants
import com.jati.dev.layout.utils.ListItemDecoration
import kotlinx.android.synthetic.main.fragment_history.*
import javax.inject.Inject

/**
 * Created by Jati on 16/08/18.
 */

class HistoryFragment : BaseFragment() {

    companion object {
        @JvmStatic
        fun newInstance(): HistoryFragment {
            val historyFragment = HistoryFragment()
            val args = Bundle()
            historyFragment.arguments = args
            return historyFragment
        }
    }

    @Inject
    lateinit var historyViewModel: HistoryViewModel

    private val historyList = mutableListOf<History>()
    private val historyAdapter: HistoryAdapter by lazy { HistoryAdapter(historyList) }

    override val layout = R.layout.fragment_history

    override fun inject() {
        appComponent.inject(this)
    }

    override fun onUiLoaded() {
        with(rv_history) {
            layoutManager = LinearLayoutManager(context)
            adapter = historyAdapter
            addItemDecoration(ListItemDecoration())
        }

        historyViewModel.loadHistory().observe(this, Observer<List<History>> { list ->
            list?.let {
                if (it.isEmpty()) initDummyData() else {
                    historyList.clear()
                    historyList.addAll(it)
                    historyAdapter.notifyDataSetChanged()
                }
            }
        })
    }

    private fun initDummyData() {
        historyViewModel.addHistory(History(Constants.GO_FOOD, true, "15 Jul, 06:43 PM", "Jalan Raya"))
        historyViewModel.addHistory(History(Constants.GO_RIDE, true, "15 Jul, 06:43 PM", "Jalan Raya"))
        historyViewModel.addHistory(History(Constants.GO_MART, true, "15 Jul, 06:43 PM", "Jalan Raya"))
        historyViewModel.addHistory(History(Constants.GO_RIDE, true, "15 Jul, 06:43 PM", "Jalan Raya"))
        historyViewModel.addHistory(History(Constants.GO_RIDE, true, "15 Jul, 06:43 PM", "Jalan Raya"))
        historyViewModel.addHistory(History(Constants.GO_FOOD, true, "15 Jul, 06:43 PM", "Jalan Raya"))
        historyViewModel.addHistory(History(Constants.GO_MART, true, "15 Jul, 06:43 PM", "Jalan Raya"))
        historyViewModel.addHistory(History(Constants.GO_SEND, true, "15 Jul, 06:43 PM", "Jalan Raya"))
        historyViewModel.addHistory(History(Constants.GO_FOOD, true, "15 Jul, 06:43 PM", "Jalan Raya"))
    }
}
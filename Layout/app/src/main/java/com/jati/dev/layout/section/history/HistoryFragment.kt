package com.jati.dev.layout.section.history

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.jati.dev.layout.R
import com.jati.dev.layout.entity.History
import com.jati.dev.layout.utils.Constants
import com.jati.dev.layout.utils.ListItemDecoration
import kotlinx.android.synthetic.main.fragment_history.*

class HistoryFragment : Fragment() {

    private val historyData = mutableListOf<History>()
    private val historyAdapter by lazy {
        HistoryAdapter(historyData)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(rv_history) {
            layoutManager = LinearLayoutManager(context)
            adapter = historyAdapter
            addItemDecoration(ListItemDecoration())
        }
        initDummyData()
    }

    private fun initDummyData() {
        historyData.add(History(Constants.GO_FOOD, true, "15 Jul, 06:43 PM", "Jalan Raya"))
        historyData.add(History(Constants.GO_RIDE, true, "15 Jul, 06:43 PM", "Jalan Raya"))
        historyData.add(History(Constants.GO_MART, true, "15 Jul, 06:43 PM", "Jalan Raya"))
        historyData.add(History(Constants.GO_RIDE, true, "15 Jul, 06:43 PM", "Jalan Raya"))
        historyData.add(History(Constants.GO_RIDE, true, "15 Jul, 06:43 PM", "Jalan Raya"))
        historyData.add(History(Constants.GO_FOOD, true, "15 Jul, 06:43 PM", "Jalan Raya"))
        historyData.add(History(Constants.GO_MART, true, "15 Jul, 06:43 PM", "Jalan Raya"))
        historyData.add(History(Constants.GO_SEND, true, "15 Jul, 06:43 PM", "Jalan Raya"))
        historyData.add(History(Constants.GO_FOOD, true, "15 Jul, 06:43 PM", "Jalan Raya"))
        historyAdapter.notifyDataSetChanged()
    }

    companion object {
        @JvmStatic
        fun newInstance() = HistoryFragment().apply {}
    }
}

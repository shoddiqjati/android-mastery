package com.example.jati.practices.ui.history

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jati.practices.R
import com.example.jati.practices.entity.model.History
import com.jati.dev.layout.utils.Constants
import kotlinx.android.synthetic.main.item_history.view.*

/**
 * Created by jati on 02/08/18
 */

class HistoryAdapter(private val room: List<History>) : RecyclerView.Adapter<HistoryAdapter.HistoryHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false)
        return HistoryHolder(view)
    }

    override fun getItemCount(): Int = room.size

    override fun onBindViewHolder(holder: HistoryHolder, position: Int) {
        holder.bindHistory(room[position])
    }

    inner class HistoryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindHistory(history: History) {
            itemView.apply {
                tv_status.text = if (history.status)
                    itemView.context.getString(R.string.done)
                else itemView.context.getString(R.string.on_progress)

                tv_datetime.text = history.datetime
                tv_address.text = history.address
                iv_icon.setImageResource(
                        when (history.category) {
                            Constants.GO_FOOD -> R.drawable.menu_gofood
                            Constants.GO_RIDE -> R.drawable.menu_goride
                            Constants.GO_SEND -> R.drawable.menu_gosend
                            else -> R.drawable.menu_gomart
                        }
                )
            }
        }
    }
}
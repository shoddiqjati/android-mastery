package com.jati.dev.layout.utils

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by jati on 02/08/18
 */

class ListItemDecoration : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        val width = 8;
        outRect?.let {
            it.top = if (parent?.getChildLayoutPosition(view) == 0) width * 2 else width
            it.bottom = if (parent?.getChildLayoutPosition(view) == parent?.childCount) width * 2 else width
            it.left = width * 2
            it.right = width * 2
        }
    }
}
package io.piestack.uxchallenge.util

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import io.piestack.uxchallenge.R


class SimpleDividerItemDecoration(private val mContext: Context) : RecyclerView.ItemDecoration() {
    private val mDivider: Drawable = mContext.resources.getDrawable(R.drawable.line_divider)
    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: State) {
        val left = parent.paddingLeft + mContext.convertDpToPixel(82F).toInt()
        val right = parent.width - parent.paddingRight - mContext.convertDpToPixel(16F).toInt()
        val childCount = parent.childCount
        for (i in 0 until childCount - 1) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as LayoutParams
            val top = child.bottom + params.bottomMargin
            val bottom = top + mDivider.intrinsicHeight
            mDivider.setBounds(left, top, right, bottom)
            mDivider.draw(c)
        }
    }
}
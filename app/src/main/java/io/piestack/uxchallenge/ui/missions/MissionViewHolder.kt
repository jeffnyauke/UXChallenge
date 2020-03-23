package io.piestack.uxchallenge.ui.missions

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.piestack.uxchallenge.R
import io.piestack.uxchallenge.model.Mission
import io.piestack.uxchallenge.util.toggleVisibility

class MissionViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_mission, parent, false)) {
    private var mTitleView: TextView? = null
    private var mTagView: TextView? = null

    init {
        mTitleView = itemView.findViewById(R.id.tv_title_mission)
        mTagView = itemView.findViewById(R.id.tv_tag)
    }

    fun bind(mission: Mission) {
        mTitleView?.text = mission.title

        if (layoutPosition % 2 != 0) {
            mTagView?.toggleVisibility()
        }

        itemView.setOnClickListener {
            it.startAnimation(AnimationUtils.loadAnimation(it.context, R.anim.shake))
        }
    }

}
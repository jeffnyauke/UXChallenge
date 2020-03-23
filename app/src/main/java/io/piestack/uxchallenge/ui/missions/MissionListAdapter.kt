package io.piestack.uxchallenge.ui.missions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.piestack.uxchallenge.model.Mission

class MissionListAdapter(private val list: List<Mission>) :
    RecyclerView.Adapter<MissionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MissionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MissionViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: MissionViewHolder, position: Int) {
        val mission: Mission = list[position]
        holder.bind(mission)
    }

    override fun getItemCount(): Int = list.size

}
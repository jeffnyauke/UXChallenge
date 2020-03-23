package io.piestack.uxchallenge.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.piestack.uxchallenge.R
import io.piestack.uxchallenge.model.Booking

class BookingsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_booking, parent, false)) {
    private var bDescriptionOne: TextView? = null
    private var bDescriptionTwo: TextView? = null
    private var bDescriptionThree: TextView? = null
    private var bLabel: TextView? = null

    init {
        bDescriptionOne = itemView.findViewById(R.id.tv_icon_description1)
        bDescriptionTwo = itemView.findViewById(R.id.tv_icon_description2)
        bDescriptionThree = itemView.findViewById(R.id.tv_icon_description3)
        bLabel = itemView.findViewById(R.id.tv_tag)
    }

    fun bind(booking: Booking) {
        if (booking.status == "Requested")
            bLabel?.setBackgroundResource(R.drawable.label_blue)

        bDescriptionOne?.text = booking.title
        bDescriptionTwo?.text = booking.date
        bDescriptionThree?.text = booking.time
        bLabel?.text = booking.status

        itemView.setOnClickListener {
            it.startAnimation(AnimationUtils.loadAnimation(it.context, R.anim.shake))
        }
    }

}
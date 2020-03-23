package io.piestack.uxchallenge.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.piestack.uxchallenge.model.Booking

class BookingsListAdapter(private val list: List<Booking>) :
    RecyclerView.Adapter<BookingsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return BookingsViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: BookingsViewHolder, position: Int) {
        val booking: Booking = list[position]
        holder.bind(booking)
    }

    override fun getItemCount(): Int = list.size

}
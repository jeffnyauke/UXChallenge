package io.piestack.uxchallenge.ui.bookings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.piestack.uxchallenge.R
import io.piestack.uxchallenge.model.Booking
import io.piestack.uxchallenge.ui.home.BookingsListAdapter
import kotlinx.android.synthetic.main.fragment_bookings.view.*

class BookingsFragment : Fragment() {

    private val outstandingBookings = listOf(
        Booking("Michael Mark", "Wednesday, 21 Sep at 9:00 am", "2 hrs", "Confirmed")
    )

    private val upcomingBookings = listOf(
        Booking("Adam Smith", "Wednesday, 21 Sep at 9:00 am", "2 hrs", "Requested"),
        Booking("Adam Smith", "Wednesday, 21 Sep at 9:00 am", "2 hrs", "Requested")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bookings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.recycler_bookings_outstanding.apply {
            adapter = BookingsListAdapter(outstandingBookings)
        }

        view.recycler_bookings_upcoming.apply {
            adapter = BookingsListAdapter(upcomingBookings)
        }
    }
}

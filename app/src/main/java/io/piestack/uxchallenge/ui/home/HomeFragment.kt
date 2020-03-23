package io.piestack.uxchallenge.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import io.piestack.uxchallenge.R
import io.piestack.uxchallenge.model.Booking
import io.piestack.uxchallenge.model.Chat
import io.piestack.uxchallenge.util.SimpleDividerItemDecoration
import io.piestack.uxchallenge.util.animateStatus
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private val chats = listOf(
        Chat("Warren Cook", "Okay, I'll see you there!", "17m", R.drawable.avatar_3),
        Chat(
            "Gary Garza",
            "You just make an awesome work man. Cheers!",
            "Yesterday",
            R.drawable.avatar_5
        )
    )

    private val bookings = listOf(
        Booking("Michael Mark", "Wednesday, 21 Sep at 9:00 am", "2 hrs", "Confirmed"),
        Booking("Adam Smith", "Wednesday, 21 Sep at 9:00 am", "2 hrs", "Requested"),
        Booking("Adam Smith", "Wednesday, 21 Sep at 9:00 am", "2 hrs", "Requested"),
        Booking("Adam Smith", "Wednesday, 21 Sep at 9:00 am", "2 hrs", "Requested")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var job: Job? = null
        view.button_home.setOnClickListener {
            if (job?.isCompleted != false)
                job = lifecycleScope.launch(Dispatchers.Main) {
                    animateStatus(view)
                    delay(2000L)
                }
        }

        view.recycler_chat.apply {
            addItemDecoration(SimpleDividerItemDecoration(requireContext()))
            adapter = ChatListAdapter(chats)
        }

        view.recycler_bookings.apply {
            adapter = BookingsListAdapter(bookings)
        }

        view.card_hero.setOnClickListener {
            it.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.shake))
        }

        view.btn_launch_hero.setOnClickListener {
            view.card_hero.startAnimation(
                AnimationUtils.loadAnimation(
                    requireContext(),
                    R.anim.shake
                )
            )
        }

        view.card_messages.setOnClickListener {
            it.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.shake))
        }
    }
}

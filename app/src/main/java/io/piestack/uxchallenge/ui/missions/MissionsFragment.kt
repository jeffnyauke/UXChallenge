package io.piestack.uxchallenge.ui.missions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.piestack.uxchallenge.R
import io.piestack.uxchallenge.model.Mission
import kotlinx.android.synthetic.main.fragment_missions.view.*

class MissionsFragment : Fragment() {

    private val missions = listOf(
        Mission("Teach me to cook"),
        Mission("Help with gardening"),
        Mission("Teach me to cook")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_missions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.recycler_missions.apply {
            adapter = MissionListAdapter(missions)
        }
    }
}

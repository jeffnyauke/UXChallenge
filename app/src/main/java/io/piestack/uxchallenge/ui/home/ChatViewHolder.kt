package io.piestack.uxchallenge.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import io.piestack.uxchallenge.R
import io.piestack.uxchallenge.model.Chat
import io.piestack.uxchallenge.util.animateStatus
import io.piestack.uxchallenge.util.toggleVisibility

class ChatViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_chat, parent, false)) {
    private var cNameView: TextView? = null
    private var cMessageView: TextView? = null
    private var cDateView: TextView? = null
    private var cAvatarView: ImageView? = null
    private var cOnlineView: ImageView? = null

    init {
        cNameView = itemView.findViewById(R.id.chat_name)
        cMessageView = itemView.findViewById(R.id.chat_message)
        cDateView = itemView.findViewById(R.id.chat_date)
        cAvatarView = itemView.findViewById(R.id.profile_image)
        cOnlineView = itemView.findViewById(R.id.online)
    }

    fun bind(chat: Chat) {
        cNameView?.text = chat.name
        cMessageView?.text = chat.message
        cDateView?.text = chat.date
        cAvatarView?.load(chat.image)

        if (layoutPosition % 2 == 0){
            cOnlineView?.toggleVisibility()
        }

        itemView.setOnClickListener {
            animateStatus(itemView)
        }
    }

}
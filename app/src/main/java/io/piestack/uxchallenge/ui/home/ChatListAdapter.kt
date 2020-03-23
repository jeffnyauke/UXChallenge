package io.piestack.uxchallenge.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.piestack.uxchallenge.model.Chat

class ChatListAdapter(private val list: List<Chat>)
    : RecyclerView.Adapter<ChatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ChatViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val chat: Chat = list[position]
        holder.bind(chat)
    }

    override fun getItemCount(): Int = list.size

}
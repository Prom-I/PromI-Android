package com.promi.recyclerview.notification

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.promi.R
import com.promi.databinding.ItemNotificationBinding
import com.promi.databinding.ItemNotificationFriendRequestBinding
import com.promi.recyclerview.friend.Friend
import com.promi.ui.group.FriendViewModel
import com.promi.ui.notification.NotificationViewModel

class NotificationAdapter(
    private val notificationDeleteEvent: (Notification) -> Unit
): ListAdapter<Notification, NotificationAdapter.NotificationViewHolder>(NotificationDiffUtil) {

    inner class NotificationViewHolder(private val binding: ItemNotificationFriendRequestBinding) : RecyclerView.ViewHolder(binding.root) {

            fun bind(notification: Notification){
                val deleteClickListener = View.OnClickListener { notificationDeleteEvent(notification) }

                with(binding){
                    tvNotificationContent.text = notification.content
                    tvNotificationTime.text = notification.time
                    btnNotificationConfirm.setOnClickListener(deleteClickListener)
                }

            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
            val binding = ItemNotificationFriendRequestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return NotificationViewHolder(binding)
        }

        override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
            holder.bind(currentList[position])
        }
    companion object {
        object NotificationDiffUtil : DiffUtil.ItemCallback<Notification>() {
            override fun areItemsTheSame(oldItem: Notification, newItem: Notification): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Notification, newItem: Notification): Boolean {
                return oldItem.content == newItem.content
            }
        }
    }
}
package com.example.watchusersandposts.Adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.watchusersandposts.Views.MainContainerActivity
import com.example.watchusersandposts.Models.User
import com.example.watchusersandposts.R
import com.example.watchusersandposts.Views.UserPostsFragment
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter(
    var users: List<User>
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(users[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {
            itemView.item_user_tv_name.text = user.name
            itemView.item_user_tv_username.text = user.username
            itemView.item_user_tv_email.text = user.email
            itemView.item_user_tv_address.text =
                user.address.city + ", " + user.address.street + ", " + user.address.suite

            if (!itemView.hasOnClickListeners()) {
                itemView.setOnClickListener {
                    (itemView.context as MainContainerActivity).findNavController(R.id.container)
                        .navigate(R.id.action_startFragment_to_userPostsFragment, Bundle().apply {
                            putInt(UserPostsFragment.USER_ID, user.id)
                        })
                }
            }
        }
    }
}
package com.example.watchusersandposts.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.watchusersandposts.Models.Comment
import com.example.watchusersandposts.R
import kotlinx.android.synthetic.main.item_comment.view.*

class CommentAdapter(
    var comments: List<Comment>
) : RecyclerView.Adapter<CommentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_comment, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = comments.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(comments[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(comment: Comment) {
            itemView.item_comment_tv_email.text = comment.email
            itemView.item_comment_tv_body.text = comment.body
        }
    }
}
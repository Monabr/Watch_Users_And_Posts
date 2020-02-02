package com.example.watchusersandposts.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.watchusersandposts.Models.Post
import com.example.watchusersandposts.R
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter(
    var context: Context,
    var posts: List<Post>
) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = posts.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(post: Post) {
            itemView.item_post_title.text = post.title
            itemView.item_post_body.text = post.body
            post.comments?.let {
                itemView.item_post_pb_comments.visibility = View.GONE
                itemView.item_post_comments_count.visibility = View.VISIBLE
                itemView.item_post_comments_count.text = it.size.toString()

                itemView.item_post_rv_comment_list.adapter = CommentAdapter(it)
                itemView.item_post_rv_comment_list.layoutManager = LinearLayoutManager(context)
                itemView.item_post_iv_expand_arrow.visibility = View.VISIBLE


                if (!itemView.hasOnClickListeners()) {
                    itemView.setOnClickListener {
                        when (itemView.item_post_rv_comment_list.visibility) {
                            View.GONE -> {
                                itemView.item_post_rv_comment_list.visibility = View.VISIBLE
                                itemView.item_post_iv_expand_arrow.animate().rotation(180f)
                                    .setDuration(300).start()
                            }
                            View.VISIBLE -> {
                                itemView.item_post_rv_comment_list.visibility = View.GONE
                                itemView.item_post_iv_expand_arrow.animate().rotation(0f)
                                    .setDuration(300).start()
                            }
                        }

                    }
                }
            }
        }
    }
}
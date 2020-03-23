package com.example.watchusersandposts.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.watchusersandposts.R
import com.example.watchusersandposts.adapters.PostAdapter
import com.example.watchusersandposts.dagger.DaggerStartComponent
import com.example.watchusersandposts.viewModels.UserPostsViewModel
import kotlinx.android.synthetic.main.fragment_user_posts.*

class UserPostsFragment : BaseFragment() {

    /**
     * Using to get posts and comments for them
     */
    private val viewModel: UserPostsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerStartComponent.create().inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fragment_user_posts_rv_post_list.adapter = PostAdapter()
        viewModel.adapter = fragment_user_posts_rv_post_list?.adapter as PostAdapter
        viewModel.posts.observe(this) { posts ->
            (fragment_user_posts_rv_post_list?.adapter as PostAdapter).posts = posts
            fragment_user_posts_rv_post_list.layoutManager = LinearLayoutManager(context)
            fragment_user_posts_pb_posts.visibility = View.GONE
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_posts, container, false)
    }

    companion object {
        fun newInstance(userId: Int) = UserPostsFragment().apply {
            arguments = Bundle().apply {
                putInt(USER_ID, userId)
            }
        }

        const val USER_ID = "userId"
    }
}

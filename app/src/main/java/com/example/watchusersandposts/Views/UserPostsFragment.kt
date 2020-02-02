package com.example.watchusersandposts.Views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.watchusersandposts.Adapters.PostAdapter
import com.example.watchusersandposts.Dagger.DaggerStartComponent
import com.example.watchusersandposts.R
import com.example.watchusersandposts.ViewModels.UserPostsViewModel
import kotlinx.android.synthetic.main.fragment_user_posts.*

class UserPostsFragment : BaseFragment() {

    private val viewModel: UserPostsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerStartComponent.create().inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.posts.observe(this) { posts ->
            fragment_user_posts_rv_post_list.adapter = PostAdapter(requireContext(), posts)
            fragment_user_posts_rv_post_list.layoutManager = LinearLayoutManager(context)
            fragment_user_posts_pb_posts.visibility = View.GONE
            for (index in posts.indices) {
                viewModel.getPostComments(posts[index].id).observe(this) {
                    posts[index].comments = it
                    fragment_user_posts_rv_post_list.adapter?.notifyItemChanged(index)
                }
            }
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

package com.example.watchusersandposts.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.watchusersandposts.adapters.PostAdapter
import com.example.watchusersandposts.factory.AssistedSavedStateViewModelFactory
import com.example.watchusersandposts.models.Post
import com.example.watchusersandposts.network.PlaceholderRepository
import com.example.watchusersandposts.views.UserPostsFragment.Companion.USER_ID
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class UserPostsViewModel @AssistedInject constructor(
    @Assisted private val handle: SavedStateHandle,
    val placeholderRepository: PlaceholderRepository
) : ViewModel(), CoroutineScope {
    private val job = SupervisorJob()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + job

    val userId: Int = handle[USER_ID] ?: throw IllegalArgumentException("Missing user id")

    /**
     * List of posts that will be observed by fragment
     */
    var posts: MutableLiveData<List<Post>> = MutableLiveData()

    /**
     * link to make [adapter.notifyItemChanged(int)][androidx.recyclerview.widget.RecyclerView.Adapter.notifyItemChanged] when comments will come for a post
     */
    lateinit var adapter: PostAdapter

    init {
        launch {
            val posts = placeholderRepository.getUserPosts(userId)
            this@UserPostsViewModel.posts.postValue(posts)
            for (index in posts.indices) {
                posts[index].comments =
                    placeholderRepository.getPostComments(posts[index].id)
                withContext(Dispatchers.Main) {
                    adapter.notifyItemChanged(index)
                }
            }
        }
    }

    @AssistedInject.Factory
    interface Factory :
        AssistedSavedStateViewModelFactory<UserPostsViewModel> {
        override fun create(handle: SavedStateHandle): UserPostsViewModel
    }
}


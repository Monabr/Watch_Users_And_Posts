package com.example.watchusersandposts.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.watchusersandposts.factory.AssistedSavedStateViewModelFactory
import com.example.watchusersandposts.models.Post
import com.example.watchusersandposts.network.PlaceholderRepository
import com.example.watchusersandposts.views.UserPostsFragment.Companion.USER_ID
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import java.lang.IllegalArgumentException

class UserPostsViewModel @AssistedInject constructor(
    @Assisted private val handle: SavedStateHandle,
    val placeholderRepository: PlaceholderRepository
) : ViewModel() {
    val userId: Int = handle[USER_ID] ?: throw IllegalArgumentException("Missing user id")
    var posts: LiveData<List<Post>> = placeholderRepository.getUserPosts(userId)

    fun getPostComments(postId: Int) = placeholderRepository.getPostComments(postId)



    @AssistedInject.Factory
    interface Factory :
        AssistedSavedStateViewModelFactory<UserPostsViewModel> {
        override fun create(handle: SavedStateHandle): UserPostsViewModel
    }
}


package com.example.watchusersandposts.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.watchusersandposts.Factory.AssistedSavedStateViewModelFactory
import com.example.watchusersandposts.Models.Post
import com.example.watchusersandposts.Network.PlaceholderRepository
import com.example.watchusersandposts.Views.UserPostsFragment.Companion.USER_ID
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
        override fun create(handle: SavedStateHandle): UserPostsViewModel  // may be ommited prior kotlin 1.3.60 or after PR #121 in AssistedInject lib
    }
}


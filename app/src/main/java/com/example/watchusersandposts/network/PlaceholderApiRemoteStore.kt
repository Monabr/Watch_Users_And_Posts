package com.example.watchusersandposts.network

import javax.inject.Inject

class PlaceholderApiRemoteStore @Inject constructor(
    var placeholderApi: PlaceholderApi
) {
    suspend fun getUserPosts(userId: Int)  = placeholderApi.getUserPostsAsync(userId).await()
    suspend fun getPersonMovies(postId: Int) = placeholderApi.getPostCommentsAsync(postId).await()
}
package com.example.watchusersandposts.network

import androidx.lifecycle.LiveData
import com.example.watchusersandposts.models.Comment
import com.example.watchusersandposts.models.Post
import com.example.watchusersandposts.models.User

interface PlaceholderRepository {
    fun getUsers(): LiveData<List<User>>
    suspend fun getUserPosts(userId: Int): List<Post>
    suspend fun getPostComments(postId: Int): List<Comment>
}
package com.example.watchusersandposts.network

import androidx.lifecycle.LiveData
import com.example.watchusersandposts.models.Comment
import com.example.watchusersandposts.models.Post
import com.example.watchusersandposts.models.User

interface PlaceholderRepository {
    fun getUsers(): LiveData<List<User>>
    fun getUserPosts(userId: Int): LiveData<List<Post>>
    fun getPostComments(postId: Int): LiveData<List<Comment>>
}
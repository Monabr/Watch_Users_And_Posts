package com.example.watchusersandposts.Network

import androidx.lifecycle.LiveData
import com.example.watchusersandposts.Models.Comment
import com.example.watchusersandposts.Models.Post
import com.example.watchusersandposts.Models.User

interface PlaceholderRepository {
    fun getUsers(): LiveData<List<User>>
    fun getUserPosts(userId: Int): LiveData<List<Post>>
    fun getPostComments(postId: Int): LiveData<List<Comment>>
}
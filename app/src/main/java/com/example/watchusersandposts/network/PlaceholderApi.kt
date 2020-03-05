package com.example.watchusersandposts.network

import com.example.watchusersandposts.models.Comment
import com.example.watchusersandposts.models.Post
import com.example.watchusersandposts.models.User
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceholderApi {

    @GET("users")
    fun getUsers(): Call<List<User>>

    @GET("posts")
    fun getUserPostsAsync(@Query("userId") userId: Int): Deferred<List<Post>>

    @GET("comments")
    fun getPostCommentsAsync(@Query("postId") postId: Int): Deferred<List<Comment>>
}
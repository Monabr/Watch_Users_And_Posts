package com.example.watchusersandposts.network

import com.example.watchusersandposts.models.Comment
import com.example.watchusersandposts.models.Post
import com.example.watchusersandposts.models.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceholderApi {

    @GET("users")
    fun getUsers(): Call<List<User>>

    @GET("posts")
    fun getUserPosts(@Query("userId") userId: Int): Call<List<Post>>

    @GET("comments")
    fun getPostComments(@Query("postId") postId: Int): Call<List<Comment>>
}
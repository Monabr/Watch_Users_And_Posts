package com.example.watchusersandposts.Network

import com.example.watchusersandposts.Models.Comment
import com.example.watchusersandposts.Models.Post
import com.example.watchusersandposts.Models.User
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
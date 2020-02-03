package com.example.watchusersandposts.Network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.watchusersandposts.Models.Comment
import com.example.watchusersandposts.Models.Post
import com.example.watchusersandposts.Models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

private const val PLACEHOLDER_REPOSITORY_TAG = "PlaceholderRepository"


@Singleton
class PlaceholderRepositoryImpl @Inject constructor(
    val placeholderApi: PlaceholderApi
) : PlaceholderRepository {

    override fun getUsers(): LiveData<List<User>> {
        val data = MutableLiveData<List<User>>()

        placeholderApi.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.e(PLACEHOLDER_REPOSITORY_TAG, t.message, t)
            }
        })
        return data
    }

    override fun getUserPosts(userId: Int): LiveData<List<Post>> {
        val data = MutableLiveData<List<Post>>()

        placeholderApi.getUserPosts(userId).enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.e(PLACEHOLDER_REPOSITORY_TAG, t.message, t)
            }
        })

        return data
    }

    override fun getPostComments(postId: Int): LiveData<List<Comment>> {
        val data = MutableLiveData<List<Comment>>()

        placeholderApi.getPostComments(postId).enqueue(object : Callback<List<Comment>> {
            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                Log.e(PLACEHOLDER_REPOSITORY_TAG, t.message, t)
            }
        })

        return data
    }
}
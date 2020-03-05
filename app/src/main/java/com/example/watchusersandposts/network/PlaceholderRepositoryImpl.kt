package com.example.watchusersandposts.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.watchusersandposts.models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

private const val PLACEHOLDER_REPOSITORY_TAG = "PlaceholderRepository"


@Singleton
class PlaceholderRepositoryImpl @Inject constructor(
    val placeholderApi: PlaceholderApi,
    val placeholderApiRemoteStore: PlaceholderApiRemoteStore
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

    override suspend fun getUserPosts(userId: Int) = placeholderApiRemoteStore.getUserPosts(userId)

    override suspend fun getPostComments(postId: Int) = placeholderApiRemoteStore.getPersonMovies(postId)
}
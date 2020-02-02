package com.example.watchusersandposts.Dagger.Modules

import androidx.annotation.NonNull
import com.example.watchusersandposts.Network.PlaceholderApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class PlaceholderApiModule {
    companion object {
        private const val BASE_SERVER = "https://jsonplaceholder.typicode.com/"
    }

    @Provides
    @NonNull
    fun providePlaceholderApi(): PlaceholderApi = Retrofit.Builder()
        .baseUrl(BASE_SERVER)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PlaceholderApi::class.java)
}

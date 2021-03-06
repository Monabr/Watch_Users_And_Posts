package com.example.watchusersandposts.dagger.modules

import androidx.annotation.NonNull
import com.example.watchusersandposts.network.PlaceholderApi
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
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
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(PlaceholderApi::class.java)
}

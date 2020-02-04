package com.example.watchusersandposts.dagger

import com.example.watchusersandposts.dagger.modules.MapViewModelsModule
import com.example.watchusersandposts.dagger.modules.PlaceholderApiModule
import com.example.watchusersandposts.dagger.modules.PlaceholderRepositoryImplModule
import com.example.watchusersandposts.dagger.modules.ViewModelsModule
import com.example.watchusersandposts.views.StartFragment
import com.example.watchusersandposts.views.UserPostsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelsModule::class, MapViewModelsModule::class, PlaceholderApiModule::class, PlaceholderRepositoryImplModule::class])
interface StartComponent {

    fun inject(startFragment: StartFragment)

    fun inject(userPostsFragment: UserPostsFragment)
}
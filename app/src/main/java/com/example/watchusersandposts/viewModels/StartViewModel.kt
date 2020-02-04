package com.example.watchusersandposts.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.watchusersandposts.models.User
import com.example.watchusersandposts.network.PlaceholderRepository
import javax.inject.Inject

class StartViewModel @Inject constructor(
    val placeholderRepository: PlaceholderRepository
): ViewModel() {
    val users: LiveData<List<User>> = placeholderRepository.getUsers()
}

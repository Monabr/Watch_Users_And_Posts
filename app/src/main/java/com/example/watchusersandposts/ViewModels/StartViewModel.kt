package com.example.watchusersandposts.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.watchusersandposts.Models.User
import com.example.watchusersandposts.Network.PlaceholderRepository
import javax.inject.Inject

class StartViewModel @Inject constructor(
    val placeholderRepository: PlaceholderRepository
): ViewModel() {
    val users: LiveData<List<User>> = placeholderRepository.getUsers()
}

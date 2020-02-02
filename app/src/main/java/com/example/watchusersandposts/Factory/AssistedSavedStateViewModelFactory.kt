package com.example.watchusersandposts.Factory

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel


interface AssistedSavedStateViewModelFactory<T : ViewModel> {
    fun create(handle: SavedStateHandle): T
}

package com.example.hc.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hc.model.User
import com.example.hc.model.UserRepository

class AllUsersViewModel : ViewModel() {
    private val repository = UserRepository()
    private var allUsersLiveData: LiveData<List<User>>? = null

    fun getAllUsers(): LiveData<List<User>>? {
        allUsersLiveData = repository.getUsers()
        return allUsersLiveData
    }
}
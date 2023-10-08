package com.example.bhp.network

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bhp.ui.viewmodel.HomeViewModel

class MyViewModelFactory constructor(private val repository: Repo,var context: Context): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            HomeViewModel(repository, context) as T
        }
        else {
            throw IllegalArgumentException("ViewModel Not Found")
        }

    }
}
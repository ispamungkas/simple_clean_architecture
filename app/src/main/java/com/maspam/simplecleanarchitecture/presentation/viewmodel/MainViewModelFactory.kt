package com.maspam.simplecleanarchitecture.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maspam.simplecleanarchitecture.di.Injection
import com.maspam.simplecleanarchitecture.domain.usecase.MessageUseCase

class MainViewModelFactory(
    private val messageUseCase: MessageUseCase
): ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: MainViewModelFactory? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: MainViewModelFactory(Injection.provideUseCase())
        }
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel(messageUseCase) as T
            else -> throw IllegalArgumentException("Unknown ViewModelInstance class" + modelClass.name)
        }
    }
}
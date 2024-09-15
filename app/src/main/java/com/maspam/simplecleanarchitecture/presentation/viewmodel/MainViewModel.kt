package com.maspam.simplecleanarchitecture.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maspam.simplecleanarchitecture.domain.entity.MessageEntity
import com.maspam.simplecleanarchitecture.domain.usecase.MessageUseCase

class MainViewModel(private val messageUseCase: MessageUseCase) : ViewModel() {
    private val _message = MutableLiveData<MessageEntity>()
    val message: LiveData<MessageEntity>
        get() = _message

    fun setMessage(message: String) {
        _message.value = messageUseCase.getMessage(message)
    }
}
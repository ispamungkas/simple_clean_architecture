package com.maspam.simplecleanarchitecture.domain.usecase

import com.maspam.simplecleanarchitecture.domain.entity.MessageEntity

interface MessageUseCase {
    fun getMessage(message: String): MessageEntity
}
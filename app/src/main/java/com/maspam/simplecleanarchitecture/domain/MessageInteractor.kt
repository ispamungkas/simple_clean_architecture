package com.maspam.simplecleanarchitecture.domain

import com.maspam.simplecleanarchitecture.domain.entity.MessageEntity
import com.maspam.simplecleanarchitecture.domain.repository.IMessageRepository
import com.maspam.simplecleanarchitecture.domain.usecase.MessageUseCase

class MessageInteractor(
    private val messageRepository: IMessageRepository
) : MessageUseCase {
    override fun getMessage(message: String): MessageEntity {
        return messageRepository.getMessage(message)
    }
}
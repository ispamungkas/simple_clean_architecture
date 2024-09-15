package com.maspam.simplecleanarchitecture.data.repository

import com.maspam.simplecleanarchitecture.data.MessageDataSource
import com.maspam.simplecleanarchitecture.data.datasource.IMassageDataSource
import com.maspam.simplecleanarchitecture.domain.entity.MessageEntity
import com.maspam.simplecleanarchitecture.domain.repository.IMessageRepository

class MessageRepository(private val messageDataSource: IMassageDataSource): IMessageRepository {
    override fun getMessage(message: String): MessageEntity {
        return messageDataSource.getMessageFromSource(message)
    }
}
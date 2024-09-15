package com.maspam.simplecleanarchitecture.data

import com.maspam.simplecleanarchitecture.data.datasource.IMassageDataSource
import com.maspam.simplecleanarchitecture.domain.entity.MessageEntity

class MessageDataSource : IMassageDataSource{
    override fun getMessageFromSource(message: String): MessageEntity {
        return MessageEntity("Hello $message! Welcome to Clean Architecture")
    }
}
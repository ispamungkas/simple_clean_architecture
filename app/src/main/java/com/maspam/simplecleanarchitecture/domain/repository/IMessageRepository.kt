package com.maspam.simplecleanarchitecture.domain.repository

import com.maspam.simplecleanarchitecture.domain.entity.MessageEntity

interface IMessageRepository {
    fun getMessage(message: String): MessageEntity
}
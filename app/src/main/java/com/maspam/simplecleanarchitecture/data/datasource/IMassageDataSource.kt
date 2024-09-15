package com.maspam.simplecleanarchitecture.data.datasource

import com.maspam.simplecleanarchitecture.domain.entity.MessageEntity

interface IMassageDataSource {
    fun getMessageFromSource(message: String): MessageEntity
}
package com.maspam.simplecleanarchitecture.di

import com.maspam.simplecleanarchitecture.data.MessageDataSource
import com.maspam.simplecleanarchitecture.data.datasource.IMassageDataSource
import com.maspam.simplecleanarchitecture.data.repository.MessageRepository
import com.maspam.simplecleanarchitecture.domain.MessageInteractor
import com.maspam.simplecleanarchitecture.domain.repository.IMessageRepository
import com.maspam.simplecleanarchitecture.domain.usecase.MessageUseCase

object Injection {
    fun provideUseCase(): MessageUseCase {
        val messageRepository = provideMessageRepository()
        return MessageInteractor(messageRepository)
    }

    private fun provideMessageRepository(): IMessageRepository {
        val messageDataSource = provideDataSource()
        return MessageRepository(messageDataSource)
    }

    private fun provideDataSource(): IMassageDataSource {
        return MessageDataSource()
    }
}
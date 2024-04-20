package com.narcis.room.di

import com.narcis.room.service.UserInfoService
import com.narcis.room.service.UserInfoServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UserInfoServiceModule {

    @Binds
    abstract fun bindUserService(userInfoServiceImpl: UserInfoServiceImpl): UserInfoService
}
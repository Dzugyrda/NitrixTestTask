package com.example.nitrixtesttask.exoplayer.di

import android.content.Context
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSource

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ServiceScoped
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
class PlayerModule {

    @Provides
    fun provideExoPlayer(@ApplicationContext context: Context): ExoPlayer
        = ExoPlayer.Builder(context).build()
}
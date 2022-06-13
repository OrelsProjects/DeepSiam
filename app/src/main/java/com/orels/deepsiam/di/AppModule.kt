package com.orels.deepsiam.di

import com.google.gson.Gson
import com.orels.deepsiam.data.BaseProjectUrl
import com.orels.deepsiam.data.EnvironmentRepository
import com.orels.deepsiam.data.Environments
import com.orels.deepsiam.data.remote.API
import com.orels.deepsiam.data.remote.repository.Repository
import com.orels.deepsiam.data.remote.repository.firebase.FirebaseRepostiry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @BaseProjectUrl
    fun provideBaseUrl(
        environmentRepository: EnvironmentRepository
    ) = when (environmentRepository.currentEnvironment) {
        Environments.Dev -> "https://mysterious-thicket-54888.herokuapp.com"
        Environments.Production -> "https://mysterious-thicket-54888.herokuapp.com"
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient()

    @Provides
    fun provideGson(): Gson = Gson()

    @Provides
    fun providesAPI(
        okHttpClient: OkHttpClient,
        gson: Gson,
        @BaseProjectUrl url: String
    ): API =
        Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(url)
            .build()
            .create(API::class.java)

    @Provides
    @Singleton
    fun providesRepository(): Repository = FirebaseRepostiry()
}
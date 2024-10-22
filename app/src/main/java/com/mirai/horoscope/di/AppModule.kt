package com.mirai.horoscope.di

import com.mirai.horoscope.data.ApiHoroscope
import com.mirai.horoscope.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }




    @Singleton
    @Provides
    fun providesApiHoroscope(retrofit: Retrofit): ApiHoroscope {
        return retrofit.create(ApiHoroscope::class.java)
    }


}
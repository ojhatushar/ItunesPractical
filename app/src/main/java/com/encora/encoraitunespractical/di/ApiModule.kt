package com.encora.encoraitunespractical.di

import android.content.Context
import com.encora.encoraitunespractical.BuildConfig
import com.encora.encoraitunespractical.data.remote.ApiService

import com.encora.encoraitunespractical.utils.NetworkConnectionInterceptor
import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.converter.htmlescape.HtmlEscapeStringConverter
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

import javax.inject.Singleton


/*Dependency injection for Retrofit Module*/

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    private const val BASE_URL = BuildConfig.BASE_URL

    @Singleton
    @Provides
    fun provideNetworkConnectionInterceptor(
        @ApplicationContext app: Context
    ) = NetworkConnectionInterceptor(app)


    @Singleton
    @Provides
    fun getRetrofit(networkConnectionInterceptor: NetworkConnectionInterceptor): ApiService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor { chain ->
                        chain.proceed(chain.request().newBuilder().also {
                            /*it.addHeader("issecuritydisable", "0")*/
                        }.build())
                    }.also { client ->
                        if (BuildConfig.DEBUG) {
                            val logging = HttpLoggingInterceptor()
                            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                            client.addInterceptor(logging)
                            client.addInterceptor(networkConnectionInterceptor)
                        }
                    }.build()
            )
            .addConverterFactory(TikXmlConverterFactory.create(
                TikXml.Builder()
                    .exceptionOnUnreadXml(false)
                    .addTypeConverter(String.javaClass, HtmlEscapeStringConverter())
                    .build()
            ))
            .build()
            .create(ApiService::class.java)
}
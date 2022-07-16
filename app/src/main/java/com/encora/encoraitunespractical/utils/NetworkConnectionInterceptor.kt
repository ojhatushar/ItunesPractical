package com.encora.encoraitunespractical.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.encora.encoraitunespractical.R
import com.encora.encoraitunespractical.utils.extensions.NoInternetException

import okhttp3.Interceptor
import okhttp3.Response

//Interceptor when no internet connection is there
class NetworkConnectionInterceptor(
    context: Context,
) : Interceptor {

    private val applicationContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isInternetAvailable())

            throw NoInternetException(applicationContext.getString(R.string.no_internet))
        return chain.proceed(chain.request())
    }

    private fun isInternetAvailable(): Boolean {
        var result: Boolean
        val connectivityManager =
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        connectivityManager.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                it.getNetworkCapabilities(connectivityManager.activeNetwork)?.apply {
                    result = when {
                        hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                        else -> false
                    }
                    return result
                }
            } else {
                connectivityManager.activeNetworkInfo.also {
                    return it != null && it.isConnected
                }
            }
        }
        return false
    }

}
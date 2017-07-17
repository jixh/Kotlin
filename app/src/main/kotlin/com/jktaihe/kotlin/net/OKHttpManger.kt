package com.jktaihe.kotlin.net

import android.util.Log
import com.jktaihe.engine.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import javax.security.cert.CertificateException
import javax.security.cert.X509Certificate
import okhttp3.Cookie
import okhttp3.HttpUrl
import okhttp3.CookieJar



/**
 * Created by hzjixiaohui on 2017-6-8.
 */
object OkHttpManeger {

    fun getService(): AppService {
        return appService
    }

    fun getTestServiceApi(): TestService {
        return testService
    }

    private val appService: AppService by lazy {
        getInstance(Constant.BaseURL, AppService::class.java)
    }

    private val testService: TestService by lazy{
        getInstance("http://japi.juhe.cn/", TestService::class.java)
    }

    private val client: OkHttpClient by lazy(LazyThreadSafetyMode.NONE) {
        getOkHttpClient()
    }

    private fun <T> getInstance(url: String, claz: Class<T>): T {
        return Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(claz)
    }

    private fun getOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message: String? -> Log.i("http", message) })
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(30L, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build()
    }
}
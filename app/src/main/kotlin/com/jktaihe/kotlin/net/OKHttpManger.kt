package com.jktaihe.kotlin.net

import android.util.Log
import com.jktaihe.engine.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by hzjixiaohui on 2017-6-8.
 */
class OkHttpManeger {

    companion object {

        @JvmStatic fun getService(): AppService {
            return OkHttpManeger.Singletion.INSTANCE.appService
        }

        @JvmStatic fun getTestService(): TestService {
            return OkHttpManeger.Singletion.INSTANCE.testService
        }
    }

    enum class Singletion{

        INSTANCE;

        val appService: AppService by lazy(LazyThreadSafetyMode.NONE) {
            getInstance(Constant.BaseURL,AppService::class.java)
        }

        val testService: TestService by lazy (LazyThreadSafetyMode.NONE){
            getInstance("http://japi.juhe.cn/",TestService::class.java)
        }

        private val client:OkHttpClient by lazy (LazyThreadSafetyMode.NONE){
            getOkHttpClient()
        }

        private fun <T> getInstance(url:String,claz:Class<T>):T{
            return Retrofit.Builder()
                    .baseUrl(url)
                    .client(client)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(claz)
        }

        private fun getOkHttpClient(): OkHttpClient {
            val interceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message: String? -> Log.i("http:", message) })
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .connectTimeout(30L, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .build()
        }
    }
}
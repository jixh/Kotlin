package com.jktaihe.kotlin.net

import android.util.Log

import com.jktaihe.engine.data.net.ServerException
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers

object RxResultHelper {

    fun <T> handleResult() = ObservableTransformer<GankApiResponse<T>, T> {
        apiObservable ->
        apiObservable
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap { tApiResponse ->
                    if (tApiResponse.isSuccess) {
                        createData(tApiResponse.results)
                    } else {
                        Log.d("errcode", tApiResponse.error.toString())
                        Observable.error<T>(ServerException(tApiResponse.error.toString()!!))
                    }
                }
    }

    private fun <T> createData(t: T): Observable<T> {
        return Observable.create { subscriber ->
            try {
                subscriber.onNext(t)
                subscriber.onComplete()
            } catch (e: Exception) {
                subscriber.onError(e)
            }
        }
    }
}

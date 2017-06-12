package com.jktaihe.kotlin.net

import com.jktaihe.kotlin.bean.GankBean
import com.jktaihe.kotlin.bean.ResultBean
import com.jktaihe.kotlin.net.ConfigService.pageNum
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * Created by hzjixiaohui on 2017-6-8.
 */
interface AppService {


    @GET("data/Android/$pageNum/{page}")
    fun getList(@Path("page") page:Int):Observable<GankApiResponse<List<GankBean>>>

    @GET("data/data/福利/$pageNum/{page}")
    fun get福利(@Path("page") page:Int):Observable<GankApiResponse<List<GankBean>>>


//    http://gank.io/api/data/Android/10/1
//    http://gank.io/api/data/福利/10/1
//    http://gank.io/api/data/iOS/20/2
//    http://gank.io/api/data/all/20/2
}

//https://www.juhe.cn/docs/api/id/95
interface TestService{
    @GET("joke/content/list.from?key=c8c21b0f0f42b2e30d5e25f6701b9cee&pagesize=$pageNum&pagesize=10&sort=asc")
    fun getTestList(@Query("pageNum") page: Int, @Query("time") time:String): Observable<ApiResponse<ResultBean>>
}

object ConfigService{
    const val pageNum = 10
}

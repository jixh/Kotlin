package com.jktaihe.kotlin.net


class ApiResponse<T> {
    var error_code: Int = 0
    var reason: String? = null
    var result: T? = null

    val isSuccess: Boolean
        get() {
            return error_code == SUCCESS
        }

    companion object {
       const val SUCCESS = 0
    }
}

class GankApiResponse<T> {
    var error: Boolean = false
    var results: T? = null

    val isSuccess: Boolean
        get() {
            return false.equals(error)
        }
}

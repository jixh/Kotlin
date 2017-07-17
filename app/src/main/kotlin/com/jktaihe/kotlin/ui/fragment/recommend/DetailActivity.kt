package com.jktaihe.kotlin.ui.fragment.recommend

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import com.jktaihe.engine.ui.BaseActivity

/**
 * Created by hzjixiaohui on 2017-7-17.
 */
class DetailActivity : BaseActivity(){

    private lateinit var mWebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mWebView = WebView(this)

        val url:String? = intent.getStringExtra("URL")

        mWebView.loadUrl(url)

        setContentView(mWebView)

    }


    override fun onDestroy() {
        mWebView.removeAllViews()
        mWebView.destroy()
        super.onDestroy()
    }

    companion object{
        fun startActivity(context: Context, url: String?) {
            val intent = Intent(context, DetailActivity.javaClass)
            intent.putExtra("URL", url)
            context.startActivity(intent)
        }
    }


}

package com.example.merve_oktay_odev4

import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class NewsWebPage : AppCompatActivity() {


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_web_page)

        val href = intent.getStringExtra("href")

        val webView = findViewById<WebView>(R.id.newsWebView)
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(href!!)
        webView.webViewClient = CustomWebViewClient()
    }
}
class CustomWebViewClient : WebViewClient() {
    override fun shouldOverrideUrlLoading(
        view: WebView?,
        request: WebResourceRequest?
    ): Boolean {
        //Log.d("shouldOverrideUrlLoading", "Loading")
        return super.shouldOverrideUrlLoading(view, request)
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        //Log.d("onPageStarted", "Start")
        super.onPageStarted(view, url, favicon)
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        //Log.d("onPageFinished", "Finish")
        super.onPageFinished(view, url)
    }
}

package com.example.merve_oktay_odev4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class NewsWebPage : AppCompatActivity() {
    lateinit var newsWebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_web_page)

        newsWebView = findViewById(R.id.newsWebView)

        var url=intent.getStringExtra("data")
        newsWebView.settings.javaScriptEnabled = true
        if(url!=null)
        newsWebView.loadData(url, "text/html", "utf-8")

    }
}
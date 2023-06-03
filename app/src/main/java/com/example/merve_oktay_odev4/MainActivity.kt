package com.example.merve_oktay_odev4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.widget.ListView
import com.example.merve_oktay_odev4.adapter.NewsCustomAdapter
import com.example.merve_oktay_odev4.models.News
import com.example.merve_oktay_odev4.services.NewsServices

class MainActivity : AppCompatActivity() {

    lateinit var newsListView: ListView
    lateinit var  newsList: List<News>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsListView=findViewById(R.id.newsListView)
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        val newsService=NewsServices()
        Thread {
           newsService
        }.start()
        newsList = newsService.newsData()
        val newsCustomAdapter = NewsCustomAdapter(this, newsList)
        newsListView.adapter=newsCustomAdapter



        newsListView.setOnItemClickListener { parent, view, position, id ->
            val intent=Intent(this,NewsWebPage::class.java)
            intent.putExtra("href", newsList[position].href)
            startActivity(intent)
        }


    }
}


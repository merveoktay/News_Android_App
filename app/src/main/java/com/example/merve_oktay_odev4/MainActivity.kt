package com.example.merve_oktay_odev4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.widget.ArrayAdapter
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

           val newsService=NewsServices()
        Thread (
            Runnable {  newsList = newsService.newsData()
            this.runOnUiThread(java.lang.Runnable {

            var   newsCustomAdapter = NewsCustomAdapter(this, newsList)
                newsListView.adapter=newsCustomAdapter
            })
         }).start()

        newsListView.setOnItemClickListener { parent, view, position, id ->
            var intent=Intent(this,NewsWebPage::class.java)
            intent.putExtra("url","${newsService.url}/${newsList.get(position).href}")
            startActivity(intent)
        }


    }
}


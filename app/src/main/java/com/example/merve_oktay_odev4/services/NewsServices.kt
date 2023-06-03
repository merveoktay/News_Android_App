package com.example.merve_oktay_odev4.services

import android.os.StrictMode
import com.example.merve_oktay_odev4.models.News
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class NewsServices {
    val url="https://www.haberler.com/"
    fun newsData() :List<News>{

        val arr = mutableListOf<News>()
        val url = "https://www.haberler.com/"
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val doc: Document = Jsoup.connect(url).timeout(15000).get()
        val elements: Elements = doc.getElementsByAttribute("data-headlinenumber")

        for ( element in elements) {

            val img = element.getElementsByTag("img")

            val src = img.attr("data-src")
            val href = element.attr("abs:href")
            val title = img.attr("alt")

            if ( title != "" && href != "" && src != "" ) {
                val news = News(title, src, href)
                arr.add(news)
            }
        }
        return arr
    }
}
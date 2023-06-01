package com.example.merve_oktay_odev4.services

import com.example.merve_oktay_odev4.models.News
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class NewsServices {
    val url="https://www.haberler.com/"
    fun newsData() :List<News>{

        val arr= mutableListOf<News>()

        val doc:Document = Jsoup.connect(url).timeout(15000).get()
        val elements: Elements = doc.getElementsByAttribute("data-headlinenumber")

        for ( item in elements) {
            val img = item.getElementsByTag("img")

            val href = item.attr("href")
            val src = img.attr("data-src")
            val title = img.attr("alt")
            if ( title != "" && href != "" && src != "" ) {
                val news = News(title, src, href)
                arr.add(news)
            }
        }

        return  arr
    }
}
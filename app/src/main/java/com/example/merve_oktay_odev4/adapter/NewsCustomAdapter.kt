package com.example.merve_oktay_odev4.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.merve_oktay_odev4.R
import com.example.merve_oktay_odev4.models.News
import com.bumptech.glide.Glide

class NewsCustomAdapter (private val context: Activity, private val list: List<News>):ArrayAdapter<News>(context, R.layout.custom_list_item, list){
   override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

       val rootView = context.layoutInflater.inflate(R.layout.custom_list_item, null, true)

       val r_title = rootView.findViewById<TextView>(R.id.r_tittle)
       val r_image = rootView.findViewById<ImageView>(R.id.r_img)

       val news = list.get(position)

       r_title.text = news.title


       Glide.with(rootView).load(news.img).centerCrop().into(r_image)

       return rootView
   }
}
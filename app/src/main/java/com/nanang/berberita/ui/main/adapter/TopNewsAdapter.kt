package com.nanang.berberita.ui.main.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nanang.berberita.R
import com.nanang.berberita.ui.main.view.DetailActivity
import com.nanang.beritaaja.data.model.ArticlesItem
import com.squareup.picasso.Picasso


class TopNewsAdapter(private val list: List<ArticlesItem>) : RecyclerView.Adapter<TopNewsAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
    )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val image : ImageView = holder.itemView.findViewById(R.id.img_news)
        val title : TextView = holder.itemView.findViewById(R.id.txt_title)
        loadImageFromUrl(image, list[position].urlToImage)

        title.text = list[position].title

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_NEWS, list[position])
            holder.itemView.context.startActivity(intent)
        }
    }

    fun loadImageFromUrl(imageView: ImageView?, url: String?) {
        Picasso.get()
            .load(url)
            .placeholder(R.drawable.ic_empty)
            .error(R.drawable.ic_empty)
            .into(imageView)
    }


}

package com.nanang.berberita.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.nanang.berberita.R
import com.nanang.beritaaja.data.model.ArticlesItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_NEWS = "extra_news"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setSupportActionBar(toolbar)
        if (supportActionBar != null) supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val i = intent.extras
        val news = i?.getParcelable<ArticlesItem>(EXTRA_NEWS)

        txt_title_detail.text = news?.title
        txt_author_detail.text = news?.author
        txt_desc_detail.text = news?.content

        loadImageFromUrl(img_detail, news?.urlToImage)

        btn_read.setOnClickListener {
            val intent = Intent(this, WebView::class.java)
            intent.putExtra(EXTRA_NEWS, news)
            startActivity(intent)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun loadImageFromUrl(imageView: ImageView?, url: String?) {
        Picasso.get()
            .load(url)
            .placeholder(R.drawable.ic_empty)
            .error(R.drawable.ic_empty)
            .into(imageView)
    }
}
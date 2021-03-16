package com.nanang.berberita.ui.main.view

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.nanang.berberita.R
import com.nanang.beritaaja.data.model.ArticlesItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_web_view.*
import kotlinx.android.synthetic.main.activity_web_view.progressbar

class WebView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val i = intent.extras
        val news = i?.getParcelable<ArticlesItem>(DetailActivity.EXTRA_NEWS)

        news?.url?.let { webViewFragment.loadUrl(it) }

        progressbar.playAnimation()

        webViewFragment.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                progressbar.visibility = View.VISIBLE
                progressbar.playAnimation()
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                progressbar.visibility = View.INVISIBLE
            }
        }
    }


}
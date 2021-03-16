package com.nanang.berberita.ui.main.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.nanang.berberita.R
import com.nanang.berberita.api.ApiHelper
import com.nanang.berberita.data.api.RetrofitBuilder
import com.nanang.berberita.ui.main.adapter.TopNewsAdapter
import com.nanang.berberita.utils.Status
import com.nanang.beritaaja.data.model.ArticlesItem
import com.nanang.beritaaja.data.model.News
import com.nanang.retrocoro.ui.base.ViewModelFactory
import com.nanang.retrocoro.ui.main.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    companion object{
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
        setupObservers()

        progressbar.playAnimation()
        swipeRefresh.setOnRefreshListener {
            setupObservers()
            progressbar.playAnimation()
            swipeRefresh.setRefreshing(false)
        }

    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this, ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)
    }

    private fun setupObservers() {
        viewModel.getUsers().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        progressbar.visibility = View.INVISIBLE
                        rv_news.visibility = View.VISIBLE
                        resource.data?.let { users -> retrieveList(users) }
                    }

                    Status.ERROR -> {
                        progressbar.visibility = View.INVISIBLE
                        rv_news.visibility = View.VISIBLE
                        Log.d(TAG, "setupObservers: ${it.message}")
                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    }

                    Status.LOADING -> {
                        progressbar.visibility = View.VISIBLE
                        rv_news.visibility = View.INVISIBLE
                        progressbar.playAnimation()
                    }
                }
            }
        })
    }


    private fun retrieveList(users: News) {
        val layoutManager = LinearLayoutManager(this)
        rv_news.layoutManager = layoutManager
        val adapter = TopNewsAdapter(users.articles as List<ArticlesItem>)
        rv_news.adapter = adapter

        Log.d(TAG, "retrieveList: ${users.articles}")

    }
}
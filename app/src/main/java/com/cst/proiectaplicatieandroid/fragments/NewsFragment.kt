package com.cst.proiectaplicatieandroid.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.cst.proiectaplicatieandroid.R
import com.cst.proiectaplicatieandroid.adapters.CartItemListAdapter
import com.cst.proiectaplicatieandroid.models.CartItemModel
import com.cst.proiectaplicatieandroid.models.CategoryModel
import com.cst.proiectaplicatieandroid.models.NewsModel
import com.cst.proiectaplicatieandroid.models.api.NewsAPIResponseModel
import com.cst.proiectaplicatieandroid.utils.VolleyRequestQueue
import com.cst.proiectaplicatieandroid.utils.extensions.logErrorMessage
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class NewsFragment : Fragment() {


    private val cartItemList by lazy {
        ArrayList<CartItemModel>()
    }

    private val adapter by lazy {
        CartItemListAdapter(cartItemList)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_news, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        getNews()
    }

    // Setup RecyclerView with LinearLayoutManager and custom adapter
    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(context)


        view?.findViewById<RecyclerView>(R.id.rv_news)?.apply {
            this.layoutManager = layoutManager
            this.adapter = this@NewsFragment.adapter
        }
    }

    // Performs an HTTP GET request to fetch news data
    private fun getNews() {
        val url = "https://fakestoreapi.com/products"

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                handleNewsResponse(response)
            },
            { "That didn't work!".logErrorMessage() })

        // Add the request to the RequestQueue.
        VolleyRequestQueue.addToRequestQueue(stringRequest)
    }

    // Deserialize JSON response and update RecyclerView adapter
    private fun handleNewsResponse(response: String) {
        val type = object : TypeToken<List<NewsAPIResponseModel>>() {}.type
        val responseJsonArray = Gson().fromJson<List<NewsAPIResponseModel>>(response, type)

        responseJsonArray
            .groupBy { it.category }
            .forEach {
                val categoryModel = CategoryModel(
                    name = it.key,
                    description = it.key

                )

                val news = it.value.map { newsApi ->
                    NewsModel(
                        name = newsApi.name,
                        description = newsApi.description
                    )
                }

                cartItemList.add(categoryModel)
                cartItemList.addAll(news)
            }

        adapter.notifyItemRangeInserted(0, cartItemList.size)

    }
}
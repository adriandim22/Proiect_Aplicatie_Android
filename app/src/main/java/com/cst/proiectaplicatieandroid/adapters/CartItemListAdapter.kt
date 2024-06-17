package com.cst.proiectaplicatieandroid.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cst.proiectaplicatieandroid.R
import com.cst.proiectaplicatieandroid.models.CartItemModel
import com.cst.proiectaplicatieandroid.models.CartItemType
import com.cst.proiectaplicatieandroid.models.CategoryModel
import com.cst.proiectaplicatieandroid.models.NewsModel

class CartItemListAdapter(
    private val  cartItemList: List<CartItemModel>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun getItemCount() = cartItemList.size

    override fun getItemViewType(position: Int) = cartItemList[position].type.key
    //acest itemviewtype se duce in createviewholder de mai jos

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

       return when(viewType) {
            CartItemType.NEWS.key -> {
                val view = inflater.inflate(R.layout.item_news, parent, false)
                NewsViewHolder(view) //returneaza un view nou
            }

            CartItemType.NEWS_CATEGORY.key -> {
                val view = inflater.inflate(R.layout.item_news_category, parent, false)
                NewsCategoryViewHolder(view) //returneaza un view nou
            }

            else -> super.createViewHolder(parent, viewType)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        val model = cartItemList.getOrNull(position) ?: return

        when(holder) {
            is NewsViewHolder -> (model as? NewsModel)?.let { holder.bind(it) }


            is NewsCategoryViewHolder -> (model as? CategoryModel)?.let { holder.bind(it) }
        }
    }

    //obiecte de news
    inner class NewsViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        val newsNameTextView: TextView
        val newsDescriptionTextView: TextView

        init {
            newsNameTextView = view.findViewById(R.id.tv_news_name)
            newsDescriptionTextView = view.findViewById(R.id.tv_news_description)
        }

        fun bind(model: NewsModel) {
            newsNameTextView.text = model.name
            newsDescriptionTextView.text = model.description
        }
    }

    //obiecte de category
    inner class NewsCategoryViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        val categoryNameTextView: TextView
        val categoryDescriptionTextView: TextView

        init {
            categoryNameTextView = view.findViewById(R.id.tv_news_category_name)
            categoryDescriptionTextView = view.findViewById(R.id.tv_news_category_description)
        }

        fun bind(model: CategoryModel) {
            categoryNameTextView.text = model.name
            categoryDescriptionTextView.text = model.description
        }
    }
}
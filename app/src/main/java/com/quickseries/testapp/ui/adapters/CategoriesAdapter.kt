package com.quickseries.testapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.quickseries.testapp.R
import com.quickseries.testapp.models.Category
import com.quickseries.testapp.ui.viewholders.CategoryViewHolder

/**
 * Created by eddyhugues on 2017-08-10.
 */
class CategoriesAdapter(val categories: Array<Category>, val listener: View.OnClickListener?): RecyclerView.Adapter<CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val holder = CategoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false))
        holder.itemView.setOnClickListener(listener)
        return holder
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) = holder.data(categories[position])

    override fun getItemCount() = categories.size

}
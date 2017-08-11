package com.quickseries.testapp.ui.viewholders

import android.support.v4.content.ContextCompat
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.View
import com.quickseries.testapp.App
import com.quickseries.testapp.R
import com.quickseries.testapp.models.Category

/**
 * Created by eddyhugues on 2017-08-10.
 */
class CategoryViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private var title: AppCompatTextView = itemView.findViewById(R.id.title)
    private var description: AppCompatTextView = itemView.findViewById(R.id.description)
    private var image: AppCompatImageView = itemView.findViewById(R.id.image)
    private val imageRes = arrayOf(R.drawable.ic_restaurants, R.drawable.ic_place)

    fun data(category: Category) {
        image.setImageDrawable(ContextCompat.getDrawable(App.instance, imageRes[layoutPosition%2]))
        title.text = category.title
        if (category.description.isNullOrEmpty()) {
            description.visibility = View.GONE
        } else {
            description.visibility = View.VISIBLE
            description.text = Html.fromHtml(category.description)
        }
    }

}
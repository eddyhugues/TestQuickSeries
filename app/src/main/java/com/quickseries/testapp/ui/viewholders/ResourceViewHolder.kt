package com.quickseries.testapp.ui.viewholders

import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.View
import com.quickseries.testapp.R
import com.quickseries.testapp.models.Resource
import com.squareup.picasso.Picasso

/**
 * Created by eddyhugues on 2017-08-10.
 */
class ResourceViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private var title: AppCompatTextView = itemView.findViewById(R.id.title)
    private var description: AppCompatTextView = itemView.findViewById(R.id.description)
    private var image: AppCompatImageView = itemView.findViewById(R.id.image)

    fun data(resource: Resource) {
        Picasso.with(itemView.context).load(resource.photo).fit().centerCrop().into(image)
        title.text = resource.title
        if (resource.description.isNullOrEmpty()) {
            description.visibility = View.GONE
        } else {
            description.visibility = View.VISIBLE
            description.text = Html.fromHtml(resource.description)
        }
    }

}
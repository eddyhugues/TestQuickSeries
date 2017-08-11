package com.quickseries.testapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.quickseries.testapp.R
import com.quickseries.testapp.models.Resource
import com.quickseries.testapp.ui.viewholders.ResourceViewHolder

/**
 * Created by eddyhugues on 2017-08-10.
 */
class ResourcesAdapter(val resources: Array<Resource>, val listener: View.OnClickListener?): RecyclerView.Adapter<ResourceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResourceViewHolder {
        val holder = ResourceViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.resource_item, parent, false))
        holder.itemView.setOnClickListener(listener)
        return holder
    }

    override fun onBindViewHolder(holder: ResourceViewHolder, position: Int)  = holder.data(resources[position])


    override fun getItemCount() = resources.size

}
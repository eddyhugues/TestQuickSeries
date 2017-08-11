package com.quickseries.testapp.ui.abstracts

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.quickseries.testapp.R
import kotlinx.android.synthetic.main.activity_recyclerview.*


/**
 * Created by eddyhugues on 2017-08-10.
 */
abstract class RecyclerViewBaseActivity: AppCompatActivity() {

    protected val PROGRESS = 0
    protected val CONTENT = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)
        setSupportActionBar(toolbar)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.setEmptyView(empty)
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, layoutManager.orientation))
    }

    protected fun showProgress(){
        viewFlipper.displayedChild = PROGRESS
    }

    protected fun showContent(){
        viewFlipper.displayedChild = CONTENT
    }

    protected fun showError(errorRes: Int){
        viewFlipper.displayedChild = CONTENT
        empty.text = getString(errorRes)
    }
}
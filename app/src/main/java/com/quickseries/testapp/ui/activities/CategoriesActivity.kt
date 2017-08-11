package com.quickseries.testapp.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.quickseries.testapp.R
import com.quickseries.testapp.ui.abstracts.RecyclerViewBaseActivity
import com.quickseries.testapp.ui.adapters.CategoriesAdapter
import com.quickseries.testapp.utils.DbUtils
import kotlinx.android.synthetic.main.activity_recyclerview.*

class CategoriesActivity : RecyclerViewBaseActivity() {

    companion object {
        val POSITION = "POSITION"
    }

    private val handler: Handler by lazy { Handler() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(R.string.categories)
        showProgress()
        DbUtils.categories()?.let {
            recyclerView.adapter = CategoriesAdapter(it, View.OnClickListener { view ->
                handler.postDelayed({
                    val intent = Intent(this@CategoriesActivity, ResourcesActivity::class.java)
                    intent.putExtra(POSITION, recyclerView.getChildLayoutPosition(view))
                    startActivity(intent)
                }, 300)
            })
            showContent()
            return
        }
        recyclerView.adapter = CategoriesAdapter(arrayOf(), null)
        showError(R.string.cannot_load_data)
    }

}

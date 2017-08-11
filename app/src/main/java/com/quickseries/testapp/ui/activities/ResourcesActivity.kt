package com.quickseries.testapp.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.ActivityCompat
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.quickseries.testapp.R
import com.quickseries.testapp.models.Resource
import com.quickseries.testapp.ui.abstracts.RecyclerViewBaseActivity
import com.quickseries.testapp.ui.adapters.ResourcesAdapter
import com.quickseries.testapp.utils.DbUtils
import kotlinx.android.synthetic.main.activity_recyclerview.*


class ResourcesActivity : RecyclerViewBaseActivity() {

    companion object {
        public final val RESOURCE = "RESOURCE"
    }

    private val handler: Handler by lazy { Handler() }

    private var orderAscending = true
    private lateinit var adapter: ResourcesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        var resources: Array<Resource>? = null
        when(intent.getIntExtra(CategoriesActivity.POSITION, 0)) {
            0 -> {
                setTitle(R.string.restaurants)
                resources = DbUtils.restaurants()
            }
            1 -> {
                setTitle(R.string.vacation_spots)
                resources = DbUtils.vacation_spots()
            }
            else -> finish()
        }

        showProgress()
        resources?.let {
            it.sortBy { it.title }
            adapter = ResourcesAdapter(it, View.OnClickListener {
                handler.postDelayed({
                    val intent = Intent(this@ResourcesActivity, ResourceDetailsActivity::class.java)
                    intent.putExtra(RESOURCE, adapter.resources[recyclerView.getChildLayoutPosition(it)])
                    startActivity(intent)
                }, 300)
            })
            recyclerView.adapter = adapter
            showContent()
            return
        }
        adapter = ResourcesAdapter(arrayOf(), null)
        recyclerView.adapter = adapter
        showError(R.string.cannot_load_data)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.resources_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> ActivityCompat.finishAfterTransition(this@ResourcesActivity)
            R.id.sort -> {
                if (orderAscending) adapter.resources.sortByDescending { it.title } else adapter.resources.sortBy { it.title }
                adapter.notifyDataSetChanged()
                orderAscending = !orderAscending
            }
        }
        return super.onOptionsItemSelected(item)
    }

}

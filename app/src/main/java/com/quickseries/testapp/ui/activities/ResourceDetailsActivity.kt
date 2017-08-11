package com.quickseries.testapp.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.text.Html
import android.view.MenuItem
import android.view.View
import com.quickseries.testapp.R
import com.quickseries.testapp.models.Resource
import com.quickseries.testapp.utils.ExternalAppUtils
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.resource_details_activity.*

class ResourceDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.resource_details_activity)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val resource: Resource = intent.getParcelableExtra(ResourcesActivity.RESOURCE)
        collapsingToolbar.title = resource.title
        Picasso.with(this).load(resource.photo).fit().centerCrop().into(image)
        resource.contactInfo?.email?.let { value ->
            if (value.isEmpty() || (value.isNotEmpty() && value[0].isNullOrEmpty())) return@let
            emailContainer.visibility = View.VISIBLE
            email.text = value[0]
            emailContainer.setOnClickListener { ExternalAppUtils.sendEmail(this@ResourceDetailsActivity, value[0])  }
        }
        resource.contactInfo?.phoneNumber?.let {  value ->
            if (value.isEmpty() || (value.isNotEmpty() && value[0].isNullOrEmpty())) return@let
            phoneContainer.visibility = View.VISIBLE
            phone.text = value[0]
            phoneContainer.setOnClickListener { ExternalAppUtils.phoneCall(this@ResourceDetailsActivity, value[0]) }
        }
        resource.contactInfo?.website?.let {  value ->
            if (value.isEmpty() || (value.isNotEmpty() && value[0].isNullOrEmpty())) return@let
            websiteContainer.visibility = View.VISIBLE
            website.text = value[0]
            websiteContainer.setOnClickListener { ExternalAppUtils.openBrowser(this@ResourceDetailsActivity, value[0]) }
        }
        resource.addresses?.let { value ->
            if (value.isEmpty() || (value.isNotEmpty() && value[0].address1?.isNullOrEmpty() ?: true)) return@let
            addressContainer.visibility = View.VISIBLE
            val addressValue = arrayOf(value[0].address1, value[0].zipCode, value[0].city ,value[0].state, value[0].country)
            address.text = addressValue.joinToString(",")
            addressContainer.setOnClickListener { ExternalAppUtils.openOnMaps(this@ResourceDetailsActivity, value[0]) }
        }
        if (!resource.description.isNullOrEmpty()) {
            descriptionContainer.visibility = View.VISIBLE
            description.text = Html.fromHtml(resource.description)
        }



    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        ActivityCompat.finishAfterTransition(this)
        return super.onOptionsItemSelected(item)
    }
}

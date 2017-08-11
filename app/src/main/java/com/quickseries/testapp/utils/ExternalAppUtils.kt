package com.quickseries.testapp.utils

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.support.customtabs.CustomTabsIntent
import android.support.v4.content.ContextCompat
import com.quickseries.testapp.R
import com.quickseries.testapp.models.Address


/**
 * Created by eddyhugues on 2017-08-10.
 */
object ExternalAppUtils {

    fun sendEmail(activity: Activity, address: String) {
        val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto",address, null))
        activity.startActivity(Intent.createChooser(intent, "Send Email"))
    }

    fun phoneCall(activity: Activity, phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber))
        activity.startActivity(intent)
    }

    fun openBrowser(activity: Activity, url: String) {
        val builder = CustomTabsIntent.Builder()
        builder.setToolbarColor(ContextCompat.getColor(activity, R.color.colorPrimary))
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(activity, Uri.parse(url))
    }

    fun openOnMaps(context: Activity, address: Address?) {
        val gmmIntentUri = Uri.parse("geo:${address?.gps?.latitude ?: 0},${address?.gps?.longitude ?: 0}?q=" + Uri.encode(address?.label))
        val intent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        intent.`package` = "com.google.android.apps.maps"
        try {
            context.startActivity(intent)
        } catch (ex: ActivityNotFoundException) {
            val unrestrictedIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            context.startActivity(unrestrictedIntent)
        }

    }

}
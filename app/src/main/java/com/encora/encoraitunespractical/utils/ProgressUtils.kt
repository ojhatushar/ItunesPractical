package com.encora.encoraitunespractical.utils


import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.WindowManager
import com.encora.encoraitunespractical.R
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL


/**
 * CommonUtils class
 *
 *
 *
 *
 * This is progress dialog utils class which manage show/hide progress dialog
 *
 *
 */
object ProgressUtils {
    private var builder: Dialog? = null

    /***
     * Show progress dialog
     * @param message Message
     * @param processCount Count of total processes.
     * Like if you want to do 2 tasks at a time then just call this showProgressDialog with processCount=2 and then call dismissProgressDialog() method at every task finish
     */
    fun showProgressDialog(context: Activity) {
        if (builder == null)
            builder = Dialog(context)

        val inflater = LayoutInflater.from(context)

        val dialogView = inflater.inflate(R.layout.view_loading, null)
        builder!!.setContentView(dialogView)

        builder!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        builder!!.window?.setBackgroundDrawable(
            ColorDrawable(Color.WHITE)
        )
        builder!!.setCanceledOnTouchOutside(false)
        builder!!.setCancelable(false)
        builder!!.window?.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )

        if (!builder!!.isShowing) {
            val activity: Activity = context
            if (!activity.isFinishing) {
                try {
                    builder?.show()
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        }
    }

    fun showProgressDialog(message: String?, context: Context) {
        if (builder == null)
            builder = Dialog(context)

        val inflater = LayoutInflater.from(context)
        val dialogView = inflater.inflate(R.layout.view_loading, null)
        builder?.setContentView(dialogView)

        builder?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        builder?.window?.setBackgroundDrawable(
            ColorDrawable(Color.WHITE)
        )
        builder?.setCanceledOnTouchOutside(false)
        builder?.window?.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )

        if (builder != null) {
            if (!builder!!.isShowing) {
                builder!!.show()
            }
        }
    }

    /***
     * For dismiss progress dialog
     */
    fun dismissProgressDialog() {

        if (builder != null && builder!!.isShowing) {
            builder!!.dismiss()
            builder = null

        }
    }

    @Throws(IOException::class)
    fun drawableFromUrl(url: String?): Drawable? {
        var bitmapDrawable: BitmapDrawable? = null
        val thread = Thread {
            try {
                val x: Bitmap
                val connection: HttpURLConnection = URL(url).openConnection() as HttpURLConnection
                connection.connect()
                val input: InputStream = connection.getInputStream()
                x = BitmapFactory.decodeStream(input)
                bitmapDrawable = BitmapDrawable(Resources.getSystem(), x)
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        }

        thread.start()

        return bitmapDrawable
    }


}
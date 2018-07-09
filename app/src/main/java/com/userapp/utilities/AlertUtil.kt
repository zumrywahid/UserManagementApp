package com.userapp.utilities

import android.content.Context
import android.support.v7.app.AlertDialog

/**
 * Created on 7/8/18.
 */
class AlertUtil {
    companion object {
        fun showAlert(context: Context, title: String, message: String) {
            val dialog = AlertDialog.Builder(context).setTitle(title).setMessage(message)
                    .setNegativeButton("Oky", { dialog, i -> })
            dialog.show()
        }
    }
}
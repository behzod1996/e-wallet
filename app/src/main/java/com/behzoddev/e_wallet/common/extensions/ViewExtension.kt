package com.behzoddev.e_wallet.common.extensions

import android.app.Activity
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Activity.toastLong(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Activity.toastShort(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.toastLong(message: String) {
    Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
}

fun Fragment.toastShort(message: String) {
    Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
}

fun View.hide() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}
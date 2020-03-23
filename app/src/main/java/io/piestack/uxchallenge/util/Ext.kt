package io.piestack.uxchallenge.util

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics
import android.view.View

/**
 * Extension method to find a device width in pixels
 */
inline val Context.displayWidth: Int
    get() = resources.displayMetrics.widthPixels

fun Context.convertDpToPixel(dp: Float): Float {
    return run {
        val resources = this.resources
        val metrics = resources.displayMetrics
        dp * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }
}

/**
 * Toggle a view's visibility
 */
fun View.toggleVisibility() : View {
    visibility = when (visibility) {
        View.VISIBLE -> {
            View.INVISIBLE
        }
        else -> {
            View.INVISIBLE
        }
    }
    return this
}

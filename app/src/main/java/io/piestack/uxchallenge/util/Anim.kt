package io.piestack.uxchallenge.util

import android.animation.ValueAnimator
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.fragment_home.view.*

fun animateStatus(view: View) {
    //1
    val layoutParams = view.online.layoutParams as ConstraintLayout.LayoutParams
    val startAngle = layoutParams.circleAngle
    val endAngle = startAngle + 360

    //2
    val anim = ValueAnimator.ofFloat(startAngle, endAngle)
    anim.addUpdateListener { valueAnimator ->

        //3
        val animatedValue = valueAnimator.animatedValue as Float
        val layoutParam = view.online.layoutParams as ConstraintLayout.LayoutParams
        layoutParam.circleAngle = animatedValue
        view.online.layoutParams = layoutParam

        //4
        view.online.rotation = (animatedValue % 360 - startAngle)
    }
    //5
    anim.duration = 2000

    //6
    anim.interpolator = LinearInterpolator()
    anim.start()
}
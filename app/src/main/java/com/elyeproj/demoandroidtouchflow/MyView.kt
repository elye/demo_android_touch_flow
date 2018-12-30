package com.elyeproj.demoandroidtouchflow

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class MyView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0): View(context, attrs, defStyle) {

    companion object {
        const val TAG = "MyView"
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        traceTouchStart(5, TAG, "dispatchTouchEvent", event)
        val defaultValue = super.dispatchTouchEvent(event)
        traceTouchEnd(5, TAG, "dispatchTouchEvent", event, defaultValue)
        return defaultValue
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (Control.viewDisallowParentIntercept) {
            parent.requestDisallowInterceptTouchEvent(true)
        }
        traceTouchStart(6, TAG, "onTouchEvent", event)
        super.onTouchEvent(event)
        traceTouchEnd(6, TAG, "onTouchEvent", event, Control.viewOnTouch)
        return Control.viewOnTouch
    }
}

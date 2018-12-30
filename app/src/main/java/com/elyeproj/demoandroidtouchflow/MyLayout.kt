package com.elyeproj.demoandroidtouchflow

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.FrameLayout

class MyLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0): FrameLayout(context, attrs, defStyle) {

    companion object {
        const val TAG = "MyLayout"
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        traceTouchStart(3, TAG, "dispatchTouchEvent", event)
        val defaultValue = super.dispatchTouchEvent(event)
        traceTouchEnd(3, TAG, "dispatchTouchEvent", event, defaultValue)
        return defaultValue
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        traceTouchStart(4, TAG, "onInterceptTouchEvent", event)
        super.onInterceptTouchEvent(event)
        traceTouchEnd(4, TAG, "onInterceptTouchEvent", event, Control.layoutInterceptTouch)
        return Control.layoutInterceptTouch
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        traceTouchStart(4, TAG, "onTouchEvent", event)
        super.onTouchEvent(event)
        traceTouchEnd(4, TAG, "onTouchEvent", event, Control.layoutOnTouch)
        return Control.layoutOnTouch
    }
}
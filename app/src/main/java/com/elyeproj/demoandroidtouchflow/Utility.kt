package com.elyeproj.demoandroidtouchflow

import android.util.Log
import android.view.MotionEvent

private fun getEventString(event: MotionEvent): String {
    return when(event?.action) {
        MotionEvent.ACTION_DOWN -> "ACTION_DOWN"
        MotionEvent.ACTION_UP -> "ACTION_UP"
        MotionEvent.ACTION_MOVE -> "ACTION_MOVE"
        MotionEvent.ACTION_CANCEL -> "ACTION_CANCEL"
        MotionEvent.ACTION_OUTSIDE -> "ACTION_OUTSIDE"
        MotionEvent.ACTION_POINTER_DOWN -> "ACTION_POINTER_DOWN"
        MotionEvent.ACTION_POINTER_UP -> "ACTION_POINTER_UP"
        MotionEvent.ACTION_HOVER_MOVE -> "ACTION_HOVER_MOVE"
        MotionEvent.ACTION_SCROLL -> "ACTION_SCROLL"
        MotionEvent.ACTION_HOVER_ENTER -> "ACTION_HOVER_ENTER"
        MotionEvent.ACTION_HOVER_EXIT -> "ACTION_HOVER_EXIT"
        MotionEvent.ACTION_BUTTON_RELEASE -> "ACTION_BUTTON_RELEASE"
        else -> "ACTION_UNKNOWN"
    }
}

fun traceTouchStart(tab: Int, tag: String, function: String, event: MotionEvent) {
    var tabString = ""
    repeat(tab) {
        tabString += "\t"
    }

    Log.d("TraceTouch", "$tabString $tag: $function ${getEventString(event)} Start")
}

fun traceTouchEnd(tab: Int, tag: String, function: String, event: MotionEvent, returnValue: Boolean) {
    var tabString = ""
    repeat(tab) {
        tabString += "\t"
    }

    Log.d("TraceTouch", "$tabString $tag: $function ${getEventString(event)} End with $returnValue")
}

fun setController(controlKey: Control.Key, isCheck: Boolean) {
    when(controlKey) {
        Control.Key.ACTIVITY_DISPATCH_TOUCH ->
            Control.activityDispatchTouch = isCheck
        Control.Key.ACTIVITY_ON_TOUCH ->
            Control.activityOnTouch = isCheck
        Control.Key.LAYOUT_DISPATCH_TOUCH ->
            Control.layoutDispatchTouch = isCheck
        Control.Key.LAYOUT_INTERCEPT_TOUCH ->
            Control.layoutInterceptTouch = isCheck
        Control.Key.LAYOUT_ON_TOUCH ->
            Control.layoutOnTouch = isCheck
        Control.Key.VIEW_DISPATCH_TOUCH ->
            Control.viewDispatchTouch = isCheck
        Control.Key.VIEW_ON_TOUCH ->
            Control.viewOnTouch = isCheck
    }

    Log.d("TraceTouch", "$controlKey set $isCheck")
}

object Control {
    var activityDispatchTouch = false
    var activityOnTouch = false
    var layoutDispatchTouch = false
    var layoutInterceptTouch = false
    var layoutOnTouch = false
    var viewDispatchTouch = false
    var viewOnTouch = false

    enum class Key {
        ACTIVITY_DISPATCH_TOUCH,
        ACTIVITY_ON_TOUCH,
        LAYOUT_DISPATCH_TOUCH,
        LAYOUT_INTERCEPT_TOUCH,
        LAYOUT_ON_TOUCH,
        VIEW_DISPATCH_TOUCH,
        VIEW_ON_TOUCH
    }
}

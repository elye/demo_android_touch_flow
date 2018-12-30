package com.elyeproj.demoandroidtouchflow

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*

class MyActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MyActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(null)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.container, MyFragment()).commit()
        setupSwitch()
    }

    private fun setupSwitch() {
        activity_on_touch.setOnCheckedChangeListener { _, isChecked ->
            setController(Control.Key.ACTIVITY_ON_TOUCH, isChecked)
        }

        layout_intercept_touch.setOnCheckedChangeListener { _, isChecked ->
            setController(Control.Key.LAYOUT_INTERCEPT_TOUCH, isChecked)
        }

        layout_on_touch.setOnCheckedChangeListener { _, isChecked ->
            setController(Control.Key.LAYOUT_ON_TOUCH, isChecked)
        }

        view_on_touch.setOnCheckedChangeListener { _, isChecked ->
            setController(Control.Key.VIEW_ON_TOUCH, isChecked)
        }

        view_disallow_parent_intercept.setOnCheckedChangeListener { _, isChecked ->
            setController(Control.Key.VIEW_DISALLOW_PARENT_INTERCEPT, isChecked)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        traceTouchStart(2, TAG, "onTouchEvent", event)
        super.onTouchEvent(event)
        traceTouchEnd(2, TAG, "onTouchEvent", event, Control.activityOnTouch)
        return Control.activityOnTouch
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        traceTouchStart(1, TAG, "dispatchTouchEvent", event)
        val defaultValue = super.dispatchTouchEvent(event)
        traceTouchEnd(1, TAG, "dispatchTouchEvent", event, defaultValue)
        return defaultValue
    }
}

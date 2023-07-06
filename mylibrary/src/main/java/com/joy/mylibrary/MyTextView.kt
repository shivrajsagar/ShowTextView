package com.joy.mylibrary

import android.content.Context
import android.os.Build
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet

class MyTextView: AppCompatTextView {
    companion object {
        private const val DEFAULT_TEXT_SIZE_SP = 20f
        private const val DEFAULT_TEXT_COLOR = android.R.color.black
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context!!,
        attrs,
        defStyle) {
        init()
    }



    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs) {
        init()
    }

    constructor(context: Context?) : super(context!!) {
        init()
    }

    private fun init() {
        text = "Text Field"
        textSize = MyTextView.DEFAULT_TEXT_SIZE_SP

        // Set default text color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setTextColor(context.getColor(MyTextView.DEFAULT_TEXT_COLOR))
        }
    }
}
package com.google.androidstudio.motionlayoutexample.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.ImageView

class BoundsImageView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr) {

    var mPaint = Paint()

    init {
        mPaint.setARGB(255, 200, 0, 0)
        mPaint.strokeWidth = 4f
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawLine(0f, 0f, width.toFloat(), height.toFloat(), mPaint)
        canvas?.drawLine(0f, height.toFloat(), width.toFloat(), 0f, mPaint)
    }
}
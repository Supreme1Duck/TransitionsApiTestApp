package com.example.transitionsapitestapp.utils

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import androidx.core.content.ContextCompat
import com.example.transitionsapitestapp.R

class CustomLoadingView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var paint: Paint = Paint()
    private var radius: Float = 0F
    private val startAngle = 90f
    private val greyColor = ContextCompat.getColor(context, android.R.color.black)
    private var arcs = emptyList<Arc>()
    private val rect: RectF = RectF(0f, 0f, 0f, 0f)
    private var animator: Animator? = null
    private var currentSweepAngle = 0

    var colors: List<Color> = emptyList()
        set(value) {
            if (field != value || arcs.isEmpty()) {
                field = value
                computeArcs()
            }
        }

    init {
        paint = Paint().apply {
            color = context.resources.getColor(android.R.color.black)
            style = Paint.Style.FILL
            isAntiAlias = true
        }
        computeArcs()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        rect.set(0f, 0f, w.toFloat(), h.toFloat())
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        var width = 0
        var height = 0

        if (
            widthMode == MeasureSpec.EXACTLY && heightMode == MeasureSpec.EXACTLY
        ) {
            width = widthSize
            height = heightSize
        } else if (
            widthMode == MeasureSpec.UNSPECIFIED && heightMode == MeasureSpec.UNSPECIFIED
        ) {
            width = 1000
            height = 1000
        } else if (
            widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST
        ) {
            width = 1000
            height = 1000
        }

        radius = (width / 2).toFloat()

        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        arcs.forEach { arc ->
            if (currentSweepAngle > arc.start + arc.sweep) {
                paint.color = arc.color
                canvas.drawArc(
                    rect,
                    startAngle + arc.start,
                    arc.sweep,
                    true,
                    paint
                )

            } else if (currentSweepAngle > arc.start) {
                paint.color = arc.color
                canvas.drawArc(
                    rect,
                    startAngle + arc.start,
                    currentSweepAngle - arc.start,
                    true,
                    paint
                )
            }
        }
    }

    private fun startAnimation() {
        animator?.cancel()
        animator = ValueAnimator.ofInt(0, 360).apply {
            duration = 500
            interpolator = LinearInterpolator()
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
            addUpdateListener { valueAnimator ->
                currentSweepAngle = valueAnimator.animatedValue as Int
                invalidate()
            }
        }
        animator?.start()
    }

    private val colorMap = mapOf(
        Color.White to ContextCompat.getColor(context, android.R.color.white),
        Color.Blue to ContextCompat.getColor(context, android.R.color.holo_blue_dark),
        Color.Black to ContextCompat.getColor(context, android.R.color.black),
        Color.Red to ContextCompat.getColor(context, android.R.color.holo_red_dark),
        Color.Green to ContextCompat.getColor(context, R.color.purple_500)
    )

    private fun computeArcs() {
        arcs = if (colors.isEmpty()) {
            listOf(Arc(0f, 360f, greyColor))
        } else {
            val sweepSize = 360f / colors.size
            colors.mapIndexed { index, color ->
                val startAngle = index * sweepSize
                Arc(start = startAngle, sweep = sweepSize, color = colorMap.getValue(color))
            }
        }
        startAnimation()
    }
}

enum class Color {
    Blue, Black, White, Red, Green
}

data class Arc(
    val start: Float,
    val sweep: Float,
    val color: Int
)
package com.kirchhoff.curvedbottombar

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import com.google.android.material.bottomnavigation.BottomNavigationView

class CurvedBottomNavigationView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null,
                                                           defStyleAttr: Int = 0) : BottomNavigationView(context, attrs, defStyleAttr) {

    private val path: Path = Path()
    private val paint: Paint = Paint()

    private val radius: Int
    private val firstCurveStartPoint: Point
    private val firstCurveEndPoint: Point
    private val firstCurveControlPoint1: Point
    private val firstCurveControlPoint2: Point

    private val secondCurveStartPoint: Point
    private val secondCurveEndPoint: Point
    private val secondCurveControlPoint1: Point
    private val secondCurveControlPoint2: Point

    init {
        with(paint) {
            style = Paint.Style.FILL_AND_STROKE
            color = Color.WHITE
        }
        radius = 256 / 2
        firstCurveStartPoint = Point()
        firstCurveEndPoint = Point()
        firstCurveControlPoint1 = Point()
        firstCurveControlPoint2 = Point()
        secondCurveStartPoint = Point()
        secondCurveEndPoint = Point()
        secondCurveControlPoint1 = Point()
        secondCurveControlPoint2 = Point()
        setBackgroundColor(Color.TRANSPARENT)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        firstCurveStartPoint.set(width / 2 - radius * 2 - radius / 3, 0)
        firstCurveEndPoint.set(width / 2, radius + radius / 4)

        secondCurveStartPoint.set(width / 2, radius + radius / 4)
        secondCurveEndPoint.set(width / 2 + radius * 2 + radius / 3, 0)

        firstCurveControlPoint1.set(firstCurveStartPoint.x + radius + radius / 4, firstCurveStartPoint.y)
        firstCurveControlPoint2.set(firstCurveEndPoint.x - radius * 2 + radius, firstCurveEndPoint.y)

        secondCurveControlPoint1.set(secondCurveStartPoint.x + radius * 2 - radius, secondCurveStartPoint.y)
        secondCurveControlPoint2.set(secondCurveEndPoint.x - (radius + radius / 4), secondCurveEndPoint.y)

        path.apply {
            reset()
            moveTo(0f, 0f)
            lineTo(firstCurveStartPoint.x.toFloat(), firstCurveStartPoint.y.toFloat())

            cubicTo(
                    firstCurveControlPoint1.x.toFloat(), firstCurveControlPoint1.y.toFloat(),
                    firstCurveControlPoint2.x.toFloat(), firstCurveControlPoint2.y.toFloat(),
                    firstCurveEndPoint.x.toFloat(), firstCurveEndPoint.y.toFloat()
            )

            cubicTo(
                    secondCurveControlPoint1.x.toFloat(), secondCurveControlPoint1.y.toFloat(),
                    secondCurveControlPoint2.x.toFloat(), secondCurveControlPoint2.y.toFloat(),
                    secondCurveEndPoint.x.toFloat(), secondCurveEndPoint.y.toFloat()
            )

            lineTo(width.toFloat(), 0f)
            lineTo(width.toFloat(), height.toFloat())
            lineTo(0f, height.toFloat())
            close()
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawPath(path, paint)
    }

}

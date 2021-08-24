package com.example.bidirectionviewpager.utils

import android.graphics.Point
import kotlin.math.atan2

object MotionUtil {

    fun getDirection(point1: Point, point2: Point): Direction {
        val angle =
            getAngle(point1.x.toFloat(), point1.y.toFloat(), point2.x.toFloat(), point2.y.toFloat())
        return Direction.fromAngle(angle)
    }

    /**
     *
     * Finds the angle between two points in the plane (x1,y1) and (x2, y2)
     * The angle is measured with 0/360 being the X-axis to the right, angles
     * increase counter clockwise.
     *
     * @param x1 the x position of the first point
     * @param y1 the y position of the first point
     * @param x2 the x position of the second point
     * @param y2 the y position of the second point
     * @return the angle between two points
     */
    private fun getAngle(x1: Float, y1: Float, x2: Float, y2: Float): Double {
        val rad = atan2((y1 - y2).toDouble(), (x2 - x1).toDouble()) + Math.PI
        return (rad * HALF_MAX_ANGLE / Math.PI + HALF_MAX_ANGLE) % MAX_ANGLE
    }

    enum class Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;

        companion object {

            /**
             * Returns a direction given an angle.
             * Directions are defined as follows:
             *
             * Up: [45, 135]
             * Right: [0,45] and [315, 360]
             * Down: [225, 315]
             * Left: [135, 225]
             *
             * @param angle an angle from 0 to 360 - e
             * @return the direction of an angle
             */
            fun fromAngle(angle: Double): Direction =
                when {
                    inRange(angle, ANGLE_45, ANGLE_135) -> UP
                    inRange(angle, ZERO_ANGLE, ANGLE_45) || inRange(angle, ANGLE_315, MAX_ANGLE) -> RIGHT
                    inRange(angle, ANGLE_225, ANGLE_315) -> DOWN
                    else -> LEFT
                }

            /**
             * @param angle an angle
             * @param init the initial bound
             * @param end the final bound
             * @return returns true if the given angle is in the interval [init, end).
             */
            private fun inRange(angle: Double, init: Float, end: Float): Boolean =
                angle >= init && angle < end
        }
    }

    private const val ZERO_ANGLE = 0f
    private const val ANGLE_45 = 45f
    private const val ANGLE_135 = 135f
    private const val HALF_MAX_ANGLE = 180f
    private const val ANGLE_225 = 225f
    private const val ANGLE_315 = 315f
    private const val MAX_ANGLE = 360f
}

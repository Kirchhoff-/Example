package com.kirchhoff.coordinatebehavior.behavior

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.snackbar.Snackbar

class CustomRotateBehavior(context: Context, attrs: AttributeSet) : CoordinatorLayout.Behavior<View>(context, attrs) {

    override fun layoutDependsOn(parent: CoordinatorLayout, child: View, dependency: View) = dependency is Snackbar.SnackbarLayout

    override fun onDependentViewChanged(parent: CoordinatorLayout, child: View, dependency: View): Boolean {
        val translationY = getFabTranslationYForSnackbar(parent, child)
        val percentComplete = -translationY / dependency.height
        child.rotation = ROTATION_ANGLE * percentComplete
        child.translationY = translationY
        return false
    }

    private fun getFabTranslationYForSnackbar(parent: CoordinatorLayout, fab: View): Float {
        var minOffset = 0f
        val dependencies = parent.getDependencies(fab)
        var i = 0
        val z = dependencies.size
        while (i < z) {
            val view = dependencies[i]
            if (view is Snackbar.SnackbarLayout && parent.doViewsOverlap(fab, view)) {
                minOffset = Math.min(minOffset, view.translationY - view.getHeight())
            }
            i++
        }

        return minOffset
    }

    companion object {
        private const val ROTATION_ANGLE = 180
    }
}

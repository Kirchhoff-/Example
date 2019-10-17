package com.example.constraintanimation

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.AnticipateOvershootInterpolator
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class ConstraintLayoutAnimationActivity : AppCompatActivity() {

    private var show = false

    private lateinit var constraint: ConstraintLayout
    private lateinit var ivBackground: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_constraint_layout_animation)
        constraint = findViewById(R.id.constraint)
        ivBackground = findViewById(R.id.ivBackground)

        ivBackground.setOnClickListener {
            updateComponent(show)
            show = show.not()
        }
    }

    private fun updateComponent(show: Boolean) {
        val constraintSet = ConstraintSet()
        val resultLayout = if (show)
            R.layout.a_constraint_layout_animation
        else
            R.layout.a_constraint_layout_animation_details
        constraintSet.clone(this, resultLayout)

        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1.0f)
        transition.duration = 1200

        TransitionManager.beginDelayedTransition(constraint, transition)
        constraintSet.applyTo(constraint)
    }
}

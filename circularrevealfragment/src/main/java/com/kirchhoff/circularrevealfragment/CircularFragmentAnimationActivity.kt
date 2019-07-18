package com.kirchhoff.circularrevealfragment

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kirchhoff.circularrevealfragment.fragments.DashboardFragment
import com.kirchhoff.circularrevealfragment.utils.ExitWithAnimation
import com.kirchhoff.circularrevealfragment.utils.exitCircularReveal

class CircularFragmentAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_circular_fragment_animation)

        supportFragmentManager.beginTransaction()
                .replace(R.id.container, DashboardFragment.newInstance())
                .commit()
    }

    override fun onBackPressed() {
        with(supportFragmentManager.findFragmentById(R.id.container)) {
            // Check if the current fragment implements the [ExitWithAnimation] interface or not
            // Also check if the [ExitWithAnimation.isToBeExitedWithAnimation] is `true` or not
            if ((this as? ExitWithAnimation)?.isToBeExitedWithAnimation() == true && (this.posX != null || this.posY != null)) {
                this.view?.exitCircularReveal(this.posX!!, this.posY!!) { super.onBackPressed() } ?: super.onBackPressed()
            } else {
                super.onBackPressed()
            }
        }
    }
}
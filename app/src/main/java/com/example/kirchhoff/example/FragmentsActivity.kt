package com.example.kirchhoff.example

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.kirchhoff.example.extension.startActivity
import com.kirchhoff.circularrevealfragment.CircularFragmentAnimationActivity
import com.kirchhoff.fragmentcommunication.FragmentCommunicationActivity

@Suppress("UNUSED_PARAMETER")
class FragmentsActivity : AppCompatActivity(R.layout.a_fragments) {

    fun circularRevealFragmentAnimationExample(view: View) {
        startActivity(CircularFragmentAnimationActivity::class.java)
    }

    fun fragmentCommunication(view: View) {
        startActivity(FragmentCommunicationActivity::class.java)
    }
}

package com.kirchhoff.fragmentcommunication.viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kirchhoff.fragmentcommunication.R
import com.kirchhoff.fragmentcommunication.viewmodel.fragment.FirstViewModelFragment
import com.kirchhoff.fragmentcommunication.viewmodel.fragment.SecondViewModelFragment
import com.kirchhoff.fragmentcommunication.viewmodel.fragment.ThirdViewModelFragment

internal class FragmentCommunicationViewModelActivity :
        AppCompatActivity(R.layout.a_fragment_communication_view_model) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
                .add(R.id.firstContainer, FirstViewModelFragment())
                .add(R.id.secondContainer, SecondViewModelFragment())
                .add(R.id.thirdContainer, ThirdViewModelFragment())
                .commit()
    }
}

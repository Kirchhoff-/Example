package com.kirchhoff.fragmentcommunication.viewmodel

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kirchhoff.fragmentcommunication.R
import com.kirchhoff.fragmentcommunication.viewmodel.fragment.FirstViewModelFragment
import com.kirchhoff.fragmentcommunication.viewmodel.fragment.SecondViewModelFragment
import com.kirchhoff.fragmentcommunication.viewmodel.fragment.ThirdViewModelFragment

internal class FragmentCommunicationViewModelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_fragment_communication_view_model)

        supportFragmentManager.beginTransaction()
                .add(R.id.firstContainer, FirstViewModelFragment())
                .add(R.id.secondContainer, SecondViewModelFragment())
                .add(R.id.thirdContainer, ThirdViewModelFragment())
                .commit()
    }
}
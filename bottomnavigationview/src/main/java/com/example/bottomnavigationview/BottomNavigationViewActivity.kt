package com.example.bottomnavigationview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.bottomnavigationview.fragment.ActionFragment
import com.example.bottomnavigationview.fragment.HomeFragment
import com.example.bottomnavigationview.fragment.InformationFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigationViewActivity : AppCompatActivity() {

    private val homeFragment: Fragment = HomeFragment()
    private val actionFragment: Fragment = ActionFragment()
    private val informationFragment: Fragment = InformationFragment()
    private val fm: FragmentManager = supportFragmentManager
    private var active = homeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_bottomnavigationview)

        val navigation = findViewById<BottomNavigationView>(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        initFragments()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> changeFragment(homeFragment)
            R.id.navigation_action -> changeFragment(actionFragment)
            R.id.navigation_information -> changeFragment(informationFragment)
        }
        true
    }

    private fun changeFragment(fragment: Fragment) {
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }

    private fun initFragments() {
        fm.beginTransaction().add(R.id.mainContainer, informationFragment, "3").hide(informationFragment).commit()
        fm.beginTransaction().add(R.id.mainContainer, actionFragment, "2").hide(actionFragment).commit()
        fm.beginTransaction().add(R.id.mainContainer, homeFragment, "1").commit()
    }
}

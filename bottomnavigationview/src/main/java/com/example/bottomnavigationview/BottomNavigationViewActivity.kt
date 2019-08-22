package com.example.bottomnavigationview

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.example.bottomnavigationview.fragment.ActionFragment
import com.example.bottomnavigationview.fragment.HomeFragment
import com.example.bottomnavigationview.fragment.InformationFragment


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

        fm.beginTransaction().add(R.id.mainContainer, informationFragment, "3").hide(informationFragment).commit()
        fm.beginTransaction().add(R.id.mainContainer, actionFragment, "2").hide(actionFragment).commit()
        fm.beginTransaction().add(R.id.mainContainer, homeFragment, "1").commit()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        item ->
        when (item.itemId) {
            R.id.navigation_home -> changeFragment(homeFragment)
            R.id.navigation_action -> changeFragment(actionFragment)
            R.id.navigation_information -> changeFragment(informationFragment)
        }
        true
    }

    private fun changeFragment(fragment: Fragment) {
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = homeFragment
    }
}
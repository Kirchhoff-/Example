package com.example.bottomnavigationview

import android.os.Bundle
import android.support.annotation.NonNull
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.example.bottomnavigationview.fragment.ActionFragment
import com.example.bottomnavigationview.fragment.HomeFragment
import com.example.bottomnavigationview.fragment.InformationFragment


class BottomNavigationViewActivity : AppCompatActivity() {

    val homeFragment: Fragment = HomeFragment()
    val actionFragment: Fragment = ActionFragment()
    val informationFragment: Fragment = InformationFragment()
    val fm: FragmentManager = supportFragmentManager
    var active = homeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_bottomnavigationview)

        val navigation = findViewById<BottomNavigationView>(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        fm.beginTransaction().add(R.id.mainContainer, informationFragment, "3").hide(informationFragment).commit()
        fm.beginTransaction().add(R.id.mainContainer, actionFragment, "2").hide(actionFragment).commit()
        fm.beginTransaction().add(R.id.mainContainer, homeFragment, "1").commit()
    }

    private val mOnNavigationItemSelectedListener = object : BottomNavigationView.OnNavigationItemSelectedListener {

        override fun onNavigationItemSelected(@NonNull item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.navigation_home -> {
                    fm.beginTransaction().hide(active).show(homeFragment).commit()
                    active = homeFragment
                    return true
                }

                R.id.navigation_action -> {
                    fm.beginTransaction().hide(active).show(actionFragment).commit()
                    active = actionFragment
                    return true
                }

                R.id.navigation_information -> {
                    fm.beginTransaction().hide(active).show(informationFragment).commit()
                    active = informationFragment
                    return true
                }
            }
            return false
        }
    }
}
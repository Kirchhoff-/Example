package com.example.bidirectionviewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bidirectionviewpager.repository.CategoryImagesRepository
import kotlinx.android.synthetic.main.a_bi_direction_viewpager.biDirectionViewPager

class BiDirectionViewPagerActivity : AppCompatActivity(R.layout.a_bi_direction_viewpager) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = CategoryImagesRepository(this)

        val biAdapter = BiDirectionViewPagerAdapter(
            listOf(
                repository.getSceneryInfo(),
                repository.getCorgiInfo(),
                repository.getInteriorInfo(),
                repository.getAnimalsInfo()
            )
        )
        biDirectionViewPager.biAdapter = biAdapter
    }
}

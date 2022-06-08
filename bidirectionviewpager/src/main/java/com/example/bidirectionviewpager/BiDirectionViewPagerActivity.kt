package com.example.bidirectionviewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bidirectionviewpager.databinding.ABiDirectionViewpagerBinding
import com.example.bidirectionviewpager.repository.CategoryImagesRepository

class BiDirectionViewPagerActivity : AppCompatActivity(R.layout.a_bi_direction_viewpager) {

    private lateinit var binding: ABiDirectionViewpagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ABiDirectionViewpagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val repository = CategoryImagesRepository(this)

        val biAdapter = BiDirectionViewPagerAdapter(
            listOf(
                repository.getSceneryInfo(),
                repository.getCorgiInfo(),
                repository.getInteriorInfo(),
                repository.getAnimalsInfo()
            )
        )
        binding.biDirectionViewPager.biAdapter = biAdapter
    }
}

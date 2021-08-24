package com.example.bidirectionviewpager.repository

import android.content.Context
import com.example.bidirectionviewpager.R

class CategoryImagesRepository(private val context: Context) {

    private val sceneryImagesLinks = listOf(
        "https://i.imgur.com/FHeHGRB.jpg",
        "https://i.imgur.com/Stt4bp8.jpg",
        "https://i.imgur.com/Adcqb3a.jpg",
        "https://i.imgur.com/qk0bjhg.jpg"
    )

    private val corgiImagesLinks = listOf(
        "https://i.imgur.com/e05qeJD.jpg",
        "https://i.imgur.com/0cyNhmp.jpg",
        "https://i.imgur.com/bm3B1D2.jpg",
        "https://i.imgur.com/S27r6rM.jpg",
        "https://i.imgur.com/rb4N8PX.jpg"
    )

    private val interiorImagesLinks = listOf(
        "https://i.imgur.com/dn4RqVR.jpg",
        "https://i.imgur.com/tSon4Cu.jpg",
        "https://i.imgur.com/hjfVA8R.jpg",
        "https://i.imgur.com/6xq5eST.jpg",
        "https://i.imgur.com/DseSlT0.jpg",
        "https://i.imgur.com/tfiDgdG.jpg"
    )

    private val animalsImagesLinks = listOf(
        "https://i.imgur.com/5HEIddN.jpg",
        "https://i.imgur.com/37VjUX6.jpg",
        "https://i.imgur.com/MtImoQm.jpg",
        "https://i.imgur.com/Ye74n6j.png"
    )

    fun getSceneryInfo() = CategoryImagesInfo(
        context.getString(R.string.bidirectionviewpager_scenery),
        sceneryImagesLinks
    )

    fun getCorgiInfo() = CategoryImagesInfo(
        context.getString(R.string.bidirectionviewpager_corgi),
        corgiImagesLinks
    )

    fun getInteriorInfo() = CategoryImagesInfo(
        context.getString(R.string.bidirectionviewpager_interior),
        interiorImagesLinks
    )

    fun getAnimalsInfo() = CategoryImagesInfo(
        context.getString(R.string.bidirectionviewpager_animals),
        animalsImagesLinks
    )
}

data class CategoryImagesInfo(
    val title: String,
    val imagesLink: List<String>
)

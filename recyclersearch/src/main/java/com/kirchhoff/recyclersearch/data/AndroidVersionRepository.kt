package com.kirchhoff.recyclersearch.data

import android.content.Context
import com.kirchhoff.recyclersearch.R

class AndroidVersionRepository(private val context: Context) {

    fun getAndroidVersionsList(): List<AndroidVersion> {
        val androidVersionList = context.resources.getStringArray(R.array.android_version)
        val androidVersionText = context.resources.getStringArray(R.array.android_version_text)
        val androidVersionApi = context.resources.getStringArray(R.array.android_version_api)

        val resultList = mutableListOf<AndroidVersion>()

        for (i in androidVersionList.indices) {
            resultList.add(AndroidVersion(androidVersionList[i], androidVersionText[i],
                    androidVersionApi[i]))
        }

        return resultList
    }
}

package com.kirchhoff.recyclersearch.data

class AndroidVersionRepository {

    fun getAndroidVersionsList(): List<AndroidVersion> {
        val resultList = listOf(
                AndroidVersion("1.5", "Cupcake", "API level 3"),
                AndroidVersion("1.6", "Donut", "API level 4"),
                AndroidVersion("2.0-2.1", "Eclair", "API level 5 - 7"),
                AndroidVersion("2.2", "Froyo", "API level 8"),
                AndroidVersion("2.3", "Gingerbread", "API level 9-10"),
                AndroidVersion("3.0-3.2", "Honeycomb", "API level 11-13"),
                AndroidVersion("4.0", "Ice Cream Sandwich", "API level 14-15"),
                AndroidVersion("4.1-4.3", "JellyBean", "API level 16-18"),
                AndroidVersion("4.4", "KitKat", "API level 19"),
                AndroidVersion("5.0-5.1", "Lollipop", "API level 21-22"),
                AndroidVersion("6.0", "Marshmallow", "API level 23"),
                AndroidVersion("7.0-7.1", "Nougat", "API level 24-25"))

        return resultList
    }

}
package com.kirchhoff.thingdiffutils

import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import java.util.Random
import java.util.concurrent.TimeUnit

object ThingRepository {

    private val random = Random()

    fun simulateThings(interval: Long, timeUnit: TimeUnit): Flowable<List<Thing>> {
        return Flowable
                .interval(0, interval, timeUnit, Schedulers.computation())
                .map {
                    shuffle(randomThings()).subList(0, SHUFFLE_COEFFICIENT)
                }
    }

    private fun randomThings(): MutableList<Thing> {
        val things = ArrayList<Thing>(COUNT)
        for (i in 0 until COUNT) {
            things.add(newThing(i))
        }

        return things
    }

    private fun shuffle(things: MutableList<Thing>): List<Thing> {
        val shuffled = ArrayList<Thing>(things.size)
        while (things.isNotEmpty()) {
            val thing = things.removeAt(random.nextInt(things.size))
            shuffled.add(thing)
        }
        return shuffled
    }

    private fun newThing(id: Int) = Thing(id, String(charArrayOf(randomChar(), randomChar(),
            randomChar())), random.nextInt())

    private fun randomChar() = (random.nextInt(CHAR_BOUND) + CHAR_COEFFICIENT).toChar()

    private const val COUNT = 100
    private const val SHUFFLE_COEFFICIENT = 80
    private const val CHAR_BOUND = 25
    private const val CHAR_COEFFICIENT = 65
}

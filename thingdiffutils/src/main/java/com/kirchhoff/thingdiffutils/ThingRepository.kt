package com.kirchhoff.thingdiffutils

import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.concurrent.TimeUnit

object ThingRepository {

    private const val COUNT = 100
    private val random = Random()

    fun simulateThings(interval: Long, timeUnit: TimeUnit): Flowable<List<Thing>> {
        return Flowable
                .interval(0, interval, timeUnit, Schedulers.computation())
                .map {
                    shuffle(randomThings()).subList(0, (COUNT * 0.8f).toInt())
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
        while (!things.isEmpty()) {
            val thing = things.removeAt(random.nextInt(things.size))
            shuffled.add(thing)
        }
        return shuffled
    }

    private fun newThing(id: Int): Thing {
        val first = (random.nextInt(25) + 65).toChar()
        val second = (random.nextInt(25) + 65).toChar()
        val third = (random.nextInt(25) + 65).toChar()
        return Thing(id, String(charArrayOf(first, second, third)), random.nextInt())
    }
}

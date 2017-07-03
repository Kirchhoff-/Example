package com.example.kirchhoff.example.ui.recycler.diffutil.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Kirchhoff-
 */

public class ThingRepository {
    private static final int COUNT = 100;

    private static Random random = new Random();

    public static Flowable<List<Thing>> simulateThings(long interval, TimeUnit timeUnit) {
        return Flowable
                .interval(0, interval, timeUnit, Schedulers.computation())
                .map(new Function<Long, List<Thing>>() {
                    @Override
                    public List<Thing> apply(@NonNull Long aLong) throws Exception {
                        return shuffle(randomThings()).subList(0, (int) (COUNT * 0.8f));
                    }
                });
    }

    private static List<Thing> randomThings() {
        List<Thing> things = new ArrayList<>(COUNT);
        for (int i = 0; i < COUNT; i++) {
            things.add(newThing(i));
        }

        return things;
    }

    private static List<Thing> shuffle(List<Thing> things) {
        List<Thing> shuffled = new ArrayList<>(things.size());
        while (!things.isEmpty()) {
            Thing thing = things.remove(random.nextInt(things.size()));
            shuffled.add(thing);
        }
        return shuffled;
    }

    private static Thing newThing(int id) {
        Thing.Builder builder = Thing.builder();

        builder.id(id);
        char first = (char) (random.nextInt(25) + 65);
        char second = (char) (random.nextInt(25) + 65);
        char third = (char) (random.nextInt(25) + 65);
        builder.text(String.valueOf(new char[]{first, second, third}));
        builder.color(random.nextInt());

        return builder.build();
    }
}

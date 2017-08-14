package com.example.kirchhoff.example.architecture.example2.mvp;

import com.example.kirchhoff.example.architecture.example2.ApplicationTestCase;
import com.example.kirchhoff.example.ui.architecture.example2.mvp.Counter;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Kirchhoff-
 */

public class CounterTest extends ApplicationTestCase {

    protected Counter counter;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        counter = new Counter(0);
    }

    @Test
    public void testIncrease() throws Exception {
        assertThat(counter.increase(), is(1));
        assertThat(counter.increase(), is(2));
        assertThat(counter.increase(), is(3));
    }

    @Test
    public void testConstructor() throws Exception {
        counter = new Counter(5);
        assertThat(counter.getValue(), is(5));
    }
}

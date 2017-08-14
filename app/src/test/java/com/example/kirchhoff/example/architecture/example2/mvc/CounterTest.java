package com.example.kirchhoff.example.architecture.example2.mvc;

import com.example.kirchhoff.example.architecture.example2.ApplicationTestCase;
import com.example.kirchhoff.example.ui.architecture.example2.mvc.Counter;
import com.example.kirchhoff.example.ui.architecture.example2.mvc.OnCounterIncreaseListener;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
        OnCounterIncreaseListener listener = mock(OnCounterIncreaseListener.class);
        assertThat(counter.increase(), is(1));
        assertThat(counter.increase(), is(2));
        counter.setOnCounterIncreaseListener(listener);
        assertThat(counter.increase(), is(3));
        verify(listener).onCounterIncreased(eq(3));
    }

    @Test
    public void testConstructor() throws Exception {
        counter = new Counter(5);
        assertThat(counter.getValue(), is(5));
    }
}

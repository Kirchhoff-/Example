package com.example.kirchhoff.example.architecture.example2.mvvm;

import com.example.kirchhoff.example.BR;
import com.example.kirchhoff.example.architecture.example2.ApplicationTestCase;
import com.example.kirchhoff.example.ui.architecture.example2.mvvm.CounterViewModel;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * @author Kirchhoff-
 */

public class CounterViewModelTest extends ApplicationTestCase {

    CounterViewModel model;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        model = spy(new CounterViewModel(0));
    }

    @Test
    public void testSetValue() throws Exception {
        model.setValue(5);
        assertThat(model.getValue(), is(5));
        verify(model).notifyPropertyChanged(BR.value);
    }

    @Test
    public void testIncrease() throws Exception {
        model.increase();
        assertThat(model.getValue(), is(1));
        model.increase();
        assertThat(model.getValue(), is(2));
    }

    @Test
    public void testOnIncreaseClicked() throws Exception {
        model.onIncreaseClicked(null);
        verify(model).increase();
    }
}

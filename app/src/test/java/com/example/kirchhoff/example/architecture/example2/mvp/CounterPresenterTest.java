package com.example.kirchhoff.example.architecture.example2.mvp;

import com.example.kirchhoff.example.architecture.example2.ApplicationTestCase;
import com.example.kirchhoff.example.ui.architecture.example2.mvp.Counter;
import com.example.kirchhoff.example.ui.architecture.example2.mvp.CounterPresenter;
import com.example.kirchhoff.example.ui.architecture.example2.mvp.CounterPresenterImp;
import com.example.kirchhoff.example.ui.architecture.example2.mvp.CounterView;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Kirchhoff-
 */

public class CounterPresenterTest extends ApplicationTestCase {

    @Mock
    Counter counter;

    @Mock
    CounterView counterView;

    CounterPresenter counterPresenter;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDefaultConstructor() throws Exception {
        counterPresenter = spy(new CounterPresenterImp());
        counterPresenter.setView(counterView);
        counterPresenter.onIncreaseClicked();
        verify(counterView).setCounterText("1");
    }

    @Test
    public void testOnIncreaseClicked() throws Exception {
        counterPresenter = spy(new CounterPresenterImp(counter));
        counterPresenter.setView(counterView);
        when(counter.increase()).thenReturn(5);
        counterPresenter.onIncreaseClicked();
        verify(counterView).setCounterText("5");
    }
}

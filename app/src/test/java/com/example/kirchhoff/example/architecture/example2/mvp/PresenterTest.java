package com.example.kirchhoff.example.architecture.example2.mvp;

import com.example.kirchhoff.example.ui.architecture.example2.mvp.CounterPresenter;
import com.example.kirchhoff.example.ui.architecture.example2.mvp.CounterPresenterImp;
import com.example.kirchhoff.example.ui.architecture.example2.mvp.CounterView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * @author Kirchhoff-
 */

public class PresenterTest {

    @Mock
    CounterView view;

    CounterPresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new CounterPresenterImp();
        presenter.setView(view);
    }


    @Test
    public void testCreateAndIncrease() throws Exception {

        assertNotNull(presenter);
        presenter.onIncreaseClicked();

        verify(view).setCounterText("1");
        verifyNoMoreInteractions(view);
    }
}

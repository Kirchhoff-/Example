package com.example.kirchhoff.example.architecture.mvvm;

import com.example.kirchhoff.example.ui.architecture.data.Source;
import com.example.kirchhoff.example.ui.architecture.mvvm.ViewModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import io.reactivex.Observable;

/**
 * @author Kirchhoff-
 */

public class ViewModelTest {

    @Mock
    private Source source;

    private ViewModel viewModel;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        viewModel = new ViewModel(source);
    }

    @Test
    public void testSourceEmitsGreeting() {
        String text = "Text";

        Mockito.when(viewModel.getText()).thenReturn(Observable.just(text));

        viewModel.getText().test().assertValue(text);
    }
}

package com.example.kirchhoff.example.architecture.mvp;

import com.example.kirchhoff.example.ui.architecture.data.Source;
import com.example.kirchhoff.example.ui.architecture.mvp.MvpContract;
import com.example.kirchhoff.example.ui.architecture.mvp.Presenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import io.reactivex.Observable;

/**
 * @author Kirchhoff-
 */

public class PresenterTest {


    @Mock
    private Source source;

    @Mock
    private MvpContract.View view;

    private Presenter presenter;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        presenter = new Presenter(source, view);
    }

    @Test
    public void assertTextSetWhenViewBinded() {
        String text = "Text";
        Mockito.when(source.getText()).thenReturn(Observable.just(text));

        presenter.bind();

        Mockito.verify(view).setText(text);
    }
}

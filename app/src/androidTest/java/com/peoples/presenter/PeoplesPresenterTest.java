package com.peoples.presenter;

import com.peoples.viewinterface.PeoplesView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PeoplesPresenterTest {

    private PeoplesPresenter presenter;
    private PeoplesView view;

    @Before
    public void setUp() {
        view = mock(PeoplesView.class);
        presenter = new PeoplesPresenter();
        presenter.attach(view);
    }

    @After
    public void tearDown() {
        view = null;
        presenter = null;
    }

    @Test
    public void getPeoplesList() {
        presenter.getPeoplesList();
        verify(view, atLeastOnce()).startLoading(anyInt());

        presenter.getPeoplesList(100);
        verify(view, atLeastOnce()).startLoading(anyInt());
    }
}
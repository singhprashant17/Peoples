package com.peoples.presenter;

import android.content.Context;

import com.peoples.model.ApiResponse;
import com.peoples.util.Utility;
import com.peoples.viewinterface.PeoplesView;
import com.peoples.webservice.ApiCallMethods;
import com.peoples.webservice.WebService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import rx.Scheduler;
import rx.Single;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.plugins.RxJavaPlugins;
import rx.plugins.RxJavaSchedulersHook;
import rx.schedulers.Schedulers;

import static org.mockito.Matchers.anyInt;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Utility.class, WebService.class})
public class PeoplesPresenterTest {

    @Mock
    ApiCallMethods service;
    private PeoplesPresenter presenter;
    @Mock
    private PeoplesView view;
    private Context context;

    @Before
    public void setUp() {
        PowerMockito.mockStatic(WebService.class);
        PowerMockito.mockStatic(Utility.class);
        PowerMockito.when(Utility.checkNetwork())
                .thenAnswer(invocation -> true);
        PowerMockito.when(WebService.createService())
                .then(invocation -> service);

        // Override RxJava schedulers
        RxJavaPlugins.getInstance()
                .registerSchedulersHook(new RxJavaSchedulersHook() {
                    @Override
                    public Scheduler getComputationScheduler() {
                        return Schedulers.immediate();
                    }

                    @Override
                    public Scheduler getIOScheduler() {
                        return Schedulers.immediate();
                    }

                    @Override
                    public Scheduler getNewThreadScheduler() {
                        return Schedulers.immediate();
                    }
                });

        // Override RxAndroid schedulers
        final RxAndroidPlugins rxAndroidPlugins = RxAndroidPlugins.getInstance();
        rxAndroidPlugins.registerSchedulersHook(new RxAndroidSchedulersHook() {
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        });

        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);

        presenter = new PeoplesPresenter();
        presenter.attach(view);
    }

    @After
    public void tearDown() {
        RxJavaPlugins.getInstance().reset();
        RxAndroidPlugins.getInstance().reset();
    }

    @Test
    public void getPeoplesList() {
        final ApiResponse response = new ApiResponse();
        Mockito.when(service.getPeoplesList(10)).thenReturn(Single.just(response));

        presenter.getPeoplesList();
        Mockito.verify(view, Mockito.atLeastOnce()).startLoading(anyInt());
        Mockito.verify(view, Mockito.atLeastOnce()).stopLoading();
    }
}

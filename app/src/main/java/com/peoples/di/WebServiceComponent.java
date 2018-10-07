package com.peoples.di;

import com.peoples.presenter.PeoplesPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {WebServiceModule.class})
public interface WebServiceComponent {
    void inject(PeoplesPresenter presenter);
}

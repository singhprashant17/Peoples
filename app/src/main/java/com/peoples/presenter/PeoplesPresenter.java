package com.peoples.presenter;

import com.mvp.MessageType;
import com.mvp.MvpPresenter;
import com.peoples.ApplicationClass;
import com.peoples.R;
import com.peoples.model.ApiResponse;
import com.peoples.util.Utility;
import com.peoples.viewinterface.PeoplesView;
import com.peoples.webservice.ApiCallMethods;
import com.peoples.webservice.NoInternetException;

import java.net.SocketTimeoutException;

import javax.inject.Inject;

import rx.SingleSubscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

public class PeoplesPresenter extends MvpPresenter<PeoplesView> {
    private final Subscription subscription;
    @Inject
    ApiCallMethods service;
    private PeoplesView view;

    public PeoplesPresenter() {
        ApplicationClass.getNetComponent().inject(this);
        subscription = Subscriptions.empty();
    }

    @Override
    public void attach(PeoplesView view) {
        this.view = view;
    }

    @Override
    public void detach() {
        subscription.unsubscribe();
    }


    public void getPeoplesList(int noOfPeople) {
        getData(noOfPeople);
    }

    public void getPeoplesList() {
        // default count
        getData(10);
    }

    private void getData(int count) {
        service.getPeoplesList(count)
                .doOnSubscribe(() -> {
                    // chk if network available
                    if (!Utility.checkNetwork()) {
                        throw new NoInternetException();
                    }
                    if (count < 1) {
                        throw new IllegalStateException("count cannot be lower than zero");
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(() -> view.startLoading(R.string.loading))
                .doOnError(throwable -> {
                    throwable.printStackTrace();
                    if (throwable instanceof NoInternetException) {
                        view.showMessage(MessageType.NO_INTERNET, R.string.no_connection);
                    }
                })
                .subscribe(new SingleSubscriber<ApiResponse>() {
                    @Override
                    public void onSuccess(ApiResponse apiResponse) {
                        view.stopLoading();
                        view.displayResults(apiResponse);
                    }

                    @Override
                    public void onError(Throwable error) {
                        if (error instanceof SocketTimeoutException) {
                            view.showMessage(MessageType.NO_INTERNET, R.string.no_connection);
                        } else {
                            view.showMessage(MessageType.ERROR, R.string.error);
                        }
                        view.stopLoading();
                    }
                });
    }
}

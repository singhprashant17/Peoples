package com.peoples.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mvp.MessageType;
import com.mvp.MvpActivity;
import com.mvp.PresenterFactory;
import com.peoples.R;
import com.peoples.adapter.PeoplesListAdapter;
import com.peoples.model.ApiResponse;
import com.peoples.presenter.PeoplesPresenter;
import com.peoples.viewinterface.PeoplesView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends MvpActivity<PeoplesPresenter, PeoplesView> implements PeoplesView {

    @BindView(R.id.swipeRefreshView)
    SwipeRefreshLayout swipeRefreshView;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private PeoplesListAdapter peoplesListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViews();
    }

    @Override
    protected void onPresenterCreatedOrRestored(PeoplesPresenter presenter) {

    }

    @Override
    public PresenterFactory<PeoplesPresenter> getPresenterFactory() {
        return PeoplesPresenter::new;
    }

    private void initViews() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        swipeRefreshView.setOnRefreshListener(this::getDetails);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getDetails();
    }

    private void getDetails() {
        getPresenter().getPeoplesList(100);
    }

    @Override
    public void displayResults(ApiResponse response) {
        final List<ApiResponse.Results> results = response.getResults();
        peoplesListAdapter = new PeoplesListAdapter(this, results);
        peoplesListAdapter.setItemClick((adapter, viewHolder, position) -> {
            // on item click
        });
        peoplesListAdapter.setSelectionListener((itemView, position) -> {
            final ObjectAnimator objectAnimator = ObjectAnimator
                    .ofFloat(itemView, View.TRANSLATION_X, 0, recyclerView.getWidth())
                    .setDuration(500);
            objectAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    results.remove(position);
                    peoplesListAdapter.notifyItemRemoved(position);
                }
            });
            objectAnimator.start();
        });
        recyclerView.setAdapter(peoplesListAdapter);
    }

    @Override
    public void startLoading(int message) {
        swipeRefreshView.setRefreshing(true);
    }

    @Override
    public void stopLoading() {
        swipeRefreshView.setRefreshing(false);
    }

    @Override
    public Context getAndroidContext() {
        return this;
    }

    @Override
    public void showMessage(MessageType messageType, String msg) {
        switch (messageType) {
            case ERROR:
                Snackbar.make(swipeRefreshView, msg, Snackbar.LENGTH_SHORT);
                break;
            case NO_INTERNET:
                Snackbar.make(swipeRefreshView, msg, Snackbar.LENGTH_SHORT);
                break;
        }
    }

    @Override
    public void showMessage(MessageType messageType, int msg) {
        showMessage(messageType, getString(msg));
    }
}

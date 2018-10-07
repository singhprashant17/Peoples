package com.peoples.viewinterface;

import com.mvp.MvpLoadingView;
import com.peoples.model.ApiResponse;

public interface PeoplesView extends MvpLoadingView {
    void displayResults(ApiResponse response);
}

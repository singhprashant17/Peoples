package com.peoples.webservice;

import com.peoples.model.ApiResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Single;

public interface ApiCallMethods {

    @GET("api/")
    Single<ApiResponse> getPeoplesList(@Query("results") int count);
}

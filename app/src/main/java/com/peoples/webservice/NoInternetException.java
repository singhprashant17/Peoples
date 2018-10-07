package com.peoples.webservice;

public class NoInternetException extends RuntimeException {

    public NoInternetException() {
        super("No Internet connection");
    }
}

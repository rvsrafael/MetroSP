package com.example.logonrm.metrosp.api;

/**
 * Created by logonrm on 26/06/2017.
 */

public class APIUtils {

    private APIUtils() {}

    public static final String BASE_URL = "http://10.3.1.29:3000";

    public static API getAndroidAPIVersion() {

        return RetrofitClient.getClient(BASE_URL).create(API.class);
    }
}

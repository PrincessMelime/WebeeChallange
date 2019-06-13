package com.webee.challange.data.remote;

public class ApiConstants {

    public static final String BASE_URL = "https://openweathermap.org/api";
    public static final long CONNECT_TIMEOUT = 30000;
    public static final long READ_TIMEOUT = 30000;
    public static final long WRITE_TIMEOUT = 30000;
    public static final String API_KEY = "Put your api key here";

    private ApiConstants() {
        // Private constructor to hide the implicit one
    }
}

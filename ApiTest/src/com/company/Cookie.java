package com.company;

import okhttp3.*;
import java.io.IOException;

class Cookie {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static OkHttpClient client = new OkHttpClient();
    static String cookieManage() throws IOException {
        String json = "{\"username\":\"huangshayang@supeq.com\",\"password\":\"123456\"}";
        RequestBody body = RequestBody.create(JSON, json);
        String cookieUrl = "http://gps-alpha.tracmanager.com/api/v1/login";
        Request request = new Request.Builder()
                .url(cookieUrl)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.header("Set-Cookie");
        }
    }
}
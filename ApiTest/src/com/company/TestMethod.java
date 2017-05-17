package com.company;

import net.sf.json.JSONObject;
import okhttp3.*;
import org.apache.commons.lang.ObjectUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

class TestMethod {
    private static String baseUrl = "http://gps-alpha.tracmanager.com";
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static OkHttpClient client = new OkHttpClient();
    //post请求
    static JSONObject doPost(String url, String json, String cookie) throws Exception {
        if (cookie != null){
            RequestBody body = RequestBody.create(JSON, json);
            Request request = new Request.Builder()
                    .url(baseUrl + url)
                    .addHeader("Cookie", cookie)
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                return JSONObject.fromObject(response.body().string());
            }
        }else {
            RequestBody body = RequestBody.create(JSON, json);
            Request request = new Request.Builder()
                    .url(baseUrl + url)
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                return JSONObject.fromObject(response.body().string());
            }
        }
    }
    //get请求
    static JSONObject doGet(String url, HashMap<String, Object> param, String cookie) throws Exception {
        //拼接url字符串
        if (param != null) {
            Iterator<String> it = param.keySet().iterator();
            StringBuffer sb = null;
            while (it.hasNext()) {
                String key = it.next();
                Object value = param.get(key);
                if (sb == null) {
                    sb = new StringBuffer();
                    sb.append("?");
                } else {
                    sb.append("&");
                }
                sb.append(key);
                sb.append("=");
                sb.append(value);
            }
            url += sb.toString();
        }
        if (cookie != null){
            Request request = new Request.Builder()
                    .url(baseUrl + url)
                    .addHeader("Cookie", cookie)
                    .get()
                    .build();
            try (Response response = client.newCall(request).execute()) {
                return JSONObject.fromObject(response.body().string());
            }
        }else {
            Request request = new Request.Builder()
                    .url(baseUrl + url)
                    .get()
                    .build();
            try (Response response = client.newCall(request).execute()) {
                return JSONObject.fromObject(response.body().string());
            }
        }
    }
    //put请求
    static JSONObject doPut(String url, String json, String cookie) throws Exception {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(baseUrl + url)
                .put(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return JSONObject.fromObject(response.body().string());
        }
    }
    //delete请求
    static JSONObject doDelete(String url, String json, String cookie) throws Exception {
        if (json != null){
            RequestBody body = RequestBody.create(JSON, json);
            Request request = new Request.Builder()
                    .url(baseUrl + url)
                    .addHeader("Cookie", cookie)
                    .delete(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                return JSONObject.fromObject(response.body().string());
            }
        }else {
            Request request = new Request.Builder()
                    .url(baseUrl + url)
                    .addHeader("Cookie", cookie)
                    .delete()
                    .build();
            try (Response response = client.newCall(request).execute()) {
                return JSONObject.fromObject(response.body().string());
            }
        }
    }
}

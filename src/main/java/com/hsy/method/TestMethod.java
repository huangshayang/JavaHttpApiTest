package com.hsy.method;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import net.sf.json.JSONObject;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import static io.restassured.RestAssured.given;

/**
 * Created by HSY on 2017/6/30.
 */
public class TestMethod {
    private String method;
    private String url;
    private String data;
    private File file;
    private HashMap<String, Object> param;
    private Cookies cookie;

    private TestMethod(){}

    private TestMethod(TestMethod orgin){
        this.method = orgin.method;
        this.url = orgin.url;
        this.data = orgin.data;
        this.param = orgin.param;
        this.file = orgin.file;
        this.cookie = orgin.cookie;
    }

    public static class Builder{
        private TestMethod target;

        public Builder(String method, String url, String data){
            target = new TestMethod();
            target.method = method;
            target.url = url;
            target.data = data;
        }

        public Builder param(HashMap<String, Object> param){
            target.param = param;
            return this;
        }
        public Builder file(File file){
            target.file = file;
            return this;
        }
        public Builder cookie(Cookies cookie){
            target.cookie = cookie;
            return this;
        }

        public TestMethod build(){
            return new TestMethod(target);
        }

    }

    public Response testApi(){
        RestAssured.baseURI = "http://www-alpha.qijigps.com/api";
        switch (method) {
            case "post":
                if (cookie == null) {
                    return given().contentType(ContentType.JSON).body(data).post(url);
                }
                return given().contentType(ContentType.JSON).body(data).cookies(cookie).post(url);
            case "get":
                parseUrl(data);
                if (cookie == null) {
                    return given().get(url);
                }
                return given().cookies(cookie).get(url);
            case "put":
                return given().contentType(ContentType.JSON).body(data).cookies(cookie).put(url);
            case "delete":
                return given().param(String.valueOf(param)).cookies(cookie).delete(url);
            default:
                return given().body(data).multiPart("upload_file", file).cookies(cookie).post(url);
        }
    }

    private void parseUrl(String data) {
        if (data != null) {
            HashMap<String, Object> param = new HashMap<>();
            // 将json字符串转换成jsonObject
            JSONObject jsonObject = JSONObject.fromObject(data);
            Iterator ite = jsonObject.keys();
            // 遍历jsonObject数据,添加到Map对象
            while (ite.hasNext()) {
                String key = ite.next().toString();
                Object value = jsonObject.get(key);
                param.put(key, value);
            }
            Iterator<String> it = param.keySet().iterator();
            StringBuilder sb = null;
            while (it.hasNext()) {
                String key = it.next();
                Object value = param.get(key);
                if (sb == null) {
                    sb = new StringBuilder();
                    sb.append("?");
                } else {
                    sb.append("&");
                }
                sb.append(key);
                sb.append("=");
                sb.append(value);
            }
            url += sb;
        }
    }
}

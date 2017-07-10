package com.hsy;


import com.hsy.resultparam.ResultParam;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.sf.json.JSONObject;
import com.hsy.cookie.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;

import static io.restassured.RestAssured.defaultParser;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

/**
 * Created by HSY on 2017/6/30.
 */
public class InitTest {
//    private static HashMap<String, Object> toMap(String str) {
//        HashMap<String, Object> data = new HashMap<String, Object>();
//        // 将json字符串转换成jsonObject
//        JSONObject jsonObject = JSONObject.fromObject(str);
//        Iterator ite = jsonObject.keys();
//        // 遍历jsonObject数据,添加到Map对象
//        while (ite.hasNext()) {
//            String key = ite.next().toString();
//            Object value = jsonObject.get(key);
//            data.put(key, value);
//        }
//        // 或者直接将 jsonObject赋值给Map
//        // data = jsonObject;
//        return data;
//    }
//    private File pathmethod(){
//        return new File(this.getClass().getResource("/com/hsy/cookie").getPath());
//    }
    public static void main(String[] args) throws IOException {
//        RestAssured.baseURI = "http://www-alpha.qijigps.com/api";
//        String data1 = String.valueOf(new ResultParam("test_case.xlsx", 0).value());
//        System.out.println(data1);
//        Response response = given().contentType(ContentType.JSON).body(data1).post("/login");
//        System.out.println(response.asString());
//        String str = "{\"username\":\"13631260632\", \"password\":\"96e79218965eb72c92a549dd5a330112\"}";
////        System.out.println(toMap(str));
//        StringBuffer stringBuffer = new StringBuffer();
//        stringBuffer.append("=");
//        str += stringBuffer;
//        System.out.println(str);
//        InputStream inputStream = InitTest.class.getClassLoader().getResourceAsStream("config.json");
//        System.out.println(inputStream);
//        System.out.println(System.getProperty("java.class.path"));
//        System.out.println(new InitTest().pathmethod());
        int a = 1;
        switch (a) {
            case 1:
                System.out.println(1);
                return;
            case 2:
                System.out.println(2);
                return;
            default:
                System.out.println(3);
        }
    }
}

package com.hsy.cookie;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.io.*;
import static io.restassured.RestAssured.given;

/**
 * Created by HSY on 2017/6/30.
 */
public class Cookie {
    private static String ReadFile(String path) {
        BufferedReader reader = null;
        StringBuilder laststr = new StringBuilder();
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        String tempString;
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\hsy\\cookie\\" + path);
            inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
            reader = new BufferedReader(inputStreamReader);
            while ((tempString = reader.readLine()) != null) {
                laststr.append(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return laststr.toString();
    }
    public static Cookies getCookie(){
        String jsonContext = ReadFile("config.json");
        JSONObject jsonObject = JSONObject.fromObject(jsonContext);
        JSONArray jsonArray = JSONArray.fromObject(jsonObject.getString("cookie"));
        JSONObject jsonObject1 = JSONObject.fromObject(jsonArray.get(0));
        String url = jsonObject1.getString("url");
        String api = jsonObject1.getString("api");
        JSONObject jsonObject2 = JSONObject.fromObject(jsonArray.get(1));
        RestAssured.baseURI = url;
        return given().contentType(ContentType.JSON).body(jsonObject2.toString()).post(api).getDetailedCookies();
    }
}

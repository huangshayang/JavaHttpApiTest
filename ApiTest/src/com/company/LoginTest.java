package com.company;

import net.sf.json.JSONObject;
import org.apache.commons.lang.ObjectUtils;

import java.io.IOException;

public class LoginTest {
    private static String loginUrl = "/api/v1/login";
    //成功登录
    public static JSONObject loginSuccess() throws Exception {
        String json = "{\"username\":\"huangshayang@supeq.com\",\"password\":\"123456\"}";
        return TestMethod.doPost(loginUrl, json, null);
    }
}

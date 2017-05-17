package com.company;

import net.sf.json.JSONObject;
import java.io.IOException;
import java.util.HashMap;

public class ResetPasswordTest {
    private static String resetPasswordUrl = "/api/v1/reset/password";
    private static HashMap<String, Object> param = new HashMap<>();
    //成功重置密码
    public static JSONObject resetPasswordSuccess() throws Exception {
        param.put("email","huangshayang@supeq.com");
        return TestMethod.doGet(resetPasswordUrl, param, null);
    }
    //帐号为空
    public static JSONObject resetPasswordEmpty() throws Exception {
        param.put("email","");
        return TestMethod.doGet(resetPasswordUrl, param, null);
    }
}

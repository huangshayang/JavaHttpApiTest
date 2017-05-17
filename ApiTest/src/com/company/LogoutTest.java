package com.company;

import net.sf.json.JSONObject;
import java.io.IOException;

public class LogoutTest {
    private static String logoutUrl = "/api/v1/logout";
    //成功退出
    public static JSONObject logoutSuccess() throws Exception {
        return TestMethod.doDelete(logoutUrl, null, Cookie.cookieManage());
    }
    //无cookie退出
    public static JSONObject logoutFail() throws Exception {
        return TestMethod.doDelete(logoutUrl, null, null);
    }
}

package com.company;

import net.sf.json.JSONObject;

import java.io.IOException;

class Wspush {
    private static String wspushUrl = "/api/v1/wspush";
    static String wspushSuccess(String key) throws Exception {
        return JSONObject.fromObject(TestMethod.doGet(wspushUrl, null, Cookie.cookieManage()).getString("data")).getString(key);
    }
}

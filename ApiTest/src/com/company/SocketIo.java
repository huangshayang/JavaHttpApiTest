package com.company;

import net.sf.json.JSONObject;
import java.io.IOException;
import java.util.HashMap;

public class SocketIo {
    private static String socketIoUrl = "/socket.io/1/";
    private static HashMap<String, Object> param = new HashMap<>();
    private static JSONObject  socketIoSuccess() throws Exception {
        param.put("packet_type", "C1");
        param.put("from", 0);
        param.put("push_id", "9bb87f3b682c479998e6410308d23ca3");
        param.put("psd", Wspush.wspushSuccess("wspush_key"));
        param.put("devid", Wspush.wspushSuccess("devid"));
        param.put("t", System.currentTimeMillis());
        return TestMethod.doGet(socketIoUrl, param, Cookie.cookieManage());
    }
}

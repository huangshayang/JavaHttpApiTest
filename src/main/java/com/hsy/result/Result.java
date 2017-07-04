package com.hsy.result;

import com.hsy.cookie.Cookie;
import com.hsy.method.TestMethod;
import com.hsy.readexcel.ReadExcel;
import io.restassured.response.Response;
import net.sf.json.JSONObject;
import java.io.File;

/**
 * Created by HSY on 2017/6/30.
 */
class Result {
//    private static ReadExcel readExcel = new ReadExcel(System.getProperty("user.dir")+"\\src\\main\\java\\com\\hsy\\case\\Case.xlsx");
//    private static int[] token = readExcel.getToken();
    private static int[] token = {1};
//    private static String[] method = readExcel.getMethods();
    private static String[] method = {"get"};
//    private static String[] url = readExcel.getUrls();
    private static String[] url = {"/logout"};
//    private static String[] data = readExcel.getDatas();
//    private static String[] data = {"{\"username\":\"13631260632\", \"password\":\"96e79218965eb72c92a549dd5a330112\"}"};
    private static String[] data = {null};
//    private static HashMap<String, Object>[] param = readExcel.getParams();
//    private static File[] file = readExcel.getFiles();
    private static String[] file = {"\\src\\main\\java\\com\\hsy\\data\\updatecars.xlsx"};
//    private static int row = readExcel.getRows();
    private static int row = 1;
    private static JSONObject jsonParam = new JSONObject();

    static JSONObject testResult(){
//        String jsonResult = null;
        for (int i = 0; i < row; i++) {
            try {
                Response response;
                if (token[i] == 0) {
                    response = new TestMethod.Builder(method[i], url[i]).data(data[i]).build().testApi();
                    if (response.statusCode() == 200) {
                        jsonParam = JSONObject.fromObject(response.asString());
//                        jsonResult = testMethod.asString();
                    }else {
                        jsonParam.put("status", response.statusCode());
                        jsonParam.put("message", "HTTP状态码错误，接口请求失败");
//                        jsonResult="{\"status\": testMethod.statusCode(), \"message\": \"HTTP状态码错误，接口请求失败\"}";
                    }
                }else if (token[i] == 1) {
                    response = new TestMethod.Builder(method[i], url[i]).data(data[i]).cookie(Cookie.getCookie()).build().testApi();
                    if (response.statusCode() == 200) {
                        jsonParam = JSONObject.fromObject(response.asString());
//                        jsonResult = testMethod.asString();
                    }else {
                        jsonParam.put("status", response.statusCode());
                        jsonParam.put("message", "HTTP状态码错误，接口请求失败");
//                        jsonResult = "{\"status\": testMethod.statusCode(), \"message\": \"HTTP状态码错误，接口请求失败\"}";
                    }
                }else {
                    response = new TestMethod.Builder(method[i], url[i]).data(data[i]).file(new File(System.getProperty("user.dir")+file[i])).cookie(Cookie.getCookie()).build().testApi();
                    if (response.statusCode() == 200) {
                        jsonParam = JSONObject.fromObject(response.asString());
                    }else {
                        jsonParam.put("status", response.statusCode());
                        jsonParam.put("message", "HTTP状态码错误，接口请求失败");
                    }
                }
            }catch (Exception e){
                jsonParam.put("status", -1);
                jsonParam.put("message", "未知错误(接口请求超时或传递数据错误等");
                e.printStackTrace();
//                jsonResult = "{\"status\": -1, \"message\": \"未知错误(接口请求超时或传递数据错误等\"}";
            }
        }
//        return jsonResult;
        return jsonParam;
    }
}

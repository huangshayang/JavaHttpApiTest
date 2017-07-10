package com.hsy.result;

import com.hsy.cookie.Cookie;
import com.hsy.method.TestMethod;
import com.hsy.readexcel.ReadExcelUtil;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.sf.json.JSONObject;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by HSY on 2017/6/30.
 */
public class Result {
    private static ReadExcelUtil readExcelUtil;
    private ArrayList<Integer> token;
    private ArrayList<String> method;
    private ArrayList<String> url;
    private ArrayList<String> data;
    private ArrayList<String> file;
    private int rows;
    private JSONObject jsonParam = new JSONObject();
    private ArrayList<JSONObject> jsonObjects = new ArrayList<>();
    private final String DATAPATH = System.getProperty("user.dir") + "\\src\\main\\java\\com\\hsy\\data\\";

    public ArrayList<Integer> getCode() throws IOException {
        return readExcelUtil.getCodes();
    }

    public ArrayList<String> getMessage() throws IOException {
        return readExcelUtil.getMessages();
    }

    public ArrayList<String> getName() throws IOException {
        return readExcelUtil.getNames();
    }

    public Result(String casePath, int sheetIndex) throws IOException {
        readExcelUtil = new ReadExcelUtil(casePath, sheetIndex);
        token = readExcelUtil.getTokens();
        method = readExcelUtil.getMethods();
        url = readExcelUtil.getUrls();
        data = readExcelUtil.getDatas();
        file = readExcelUtil.getFiles();
        rows = readExcelUtil.getRows();
    }

    private void addResult(Response response) {
        if (response.statusCode() == 200) {
            jsonObjects.add(JSONObject.fromObject(response.asString()));
        }else {
            jsonParam.put("status", response.statusCode());
            jsonParam.put("message", "HTTP状态码错误，接口请求失败");
            jsonObjects.add(jsonParam);
        }
    }

     public ArrayList<JSONObject> testResult() throws IOException {
        for (int i = 0; i < rows; i++) {
            try {
                TestMethod.Builder testMethod = new TestMethod.Builder(method.get(i), url.get(i), data.get(i));
                int flag = token.get(i);
                Response response;
                switch (flag) {
                    case 0:
                        response = testMethod.build().testApi();
                        addResult(response);
//                        ValidatableResponse validatableResponse = response.then().log().ifError();
//                        long time = response.timeIn(TimeUnit.MILLISECONDS);
                        break;
                    case 1:
                        response = testMethod.cookie(Cookie.getCookie()).build().testApi();
                        addResult(response);
                        break;
                    default:
                        response = testMethod.file(new File(DATAPATH+file.get(i))).cookie(Cookie.getCookie()).build().testApi();
                        addResult(response);
                }
            }catch (Exception e){
                jsonParam.put("status", -1);
                jsonParam.put("message", "未知错误(接口请求超时或传递数据错误等");
                jsonObjects.add(jsonParam);
                e.printStackTrace();
            }
        }
        return jsonObjects;
    }
}
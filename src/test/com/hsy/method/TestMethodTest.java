package com.hsy.method;

import com.hsy.cookie.Cookie;
import com.hsy.method.TestMethod;
import com.hsy.resultparam.ResultParam;
import io.restassured.http.Cookies;
import net.sf.json.JSONObject;
import org.junit.Test;
import java.io.File;
import java.util.HashMap;

/**
 * Created by HSY on 2017/6/30.
 */
public class TestMethodTest {
    @Test
    public void testLogin() throws Exception {

    }
//    @Test
//    public void testLogout() throws Exception {
//        TestMethod testMethod = new TestMethod("get", "/logout", "", Cookie.getCookie());
//        System.out.println(testMethod.testApi().asString());
//    }
//    @Test
//    public void testCheckUserExist() throws Exception {
//        JSONObject jsonParam1 = new JSONObject();
//        jsonParam1.put("username", "13408567201");
//        TestMethod testMethod = new TestMethod("post", "/checkuserexists", jsonParam1, null, new Cookies());
//        System.out.println(testMethod.testApi().asString());
//    }
//    @Test
//    public void testUpdateCar() throws Exception {
//        File file = new File("D:\\IdeaProjects\\HiveApiTest\\src\\main\\java\\com\\hsy\\data\\updatecars.xlsx");
//        TestMethod testMethod = new TestMethod("multipart/form-data", "/updatecarsexcel", "", file, Cookie.getCookie());
//        System.out.println(testMethod.testApi().asString());
//    }
//    @Test
//    public void testGroupGid() throws Exception {
//        HashMap<String, Object> param = new HashMap<>();
//        param.put("gid", "69036d6c883442e3aba91ba7d7256d97");
//        TestMethod testMethod = new TestMethod("get", "/group", param, Cookie.getCookie());
//        System.out.println(testMethod.testApi().asString());
//    }
}
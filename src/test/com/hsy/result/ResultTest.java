package com.hsy.result;

import com.hsy.readexcel.ReadExcelUtil;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by HSY on 2017/7/3.
 */
public class ResultTest {
    @Test
    public void testResult() throws Exception {
//        ArrayList<JSONObject> jsonObjects = new Result("test_case.xlsx", 5).testResult();
//        System.out.println(jsonObjects);
//        Result result = new Result(0);
//        for (int i = 0; i < jsonObjects.size(); i++) {
//            assertEquals(result.getMessage().get(i), jsonObjects.get(i).getString("message"));
//        }
//        Result result = new Result("test_case.xlsx", 0);
//        Field field = Result.class.getDeclaredField("rows");
//        Field field1 = Result.class.getDeclaredField("code");
//        field1.setAccessible(true);
//        field.setAccessible(true);
//        System.out.println(field.get(result));
//        System.out.println(field1.get(result));
    }
}
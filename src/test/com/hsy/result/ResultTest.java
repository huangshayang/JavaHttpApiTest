package com.hsy.result;

import com.hsy.readexcel.ReadExcelUtil;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by HSY on 2017/7/3.
 */
public class ResultTest {
    @Test
    public void testResult() throws Exception {
        ArrayList<JSONObject> jsonObjects = new Result("test_case.xlsx", 5).testResult();
        System.out.println(jsonObjects);
//        Result result = new Result(0);
//        for (int i = 0; i < jsonObjects.size(); i++) {
//            assertEquals(result.getMessage().get(i), jsonObjects.get(i).getString("message"));
//        }
    }
}
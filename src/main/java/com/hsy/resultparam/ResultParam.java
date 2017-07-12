package com.hsy.resultparam;

import com.hsy.readexcel.ReadExcelUtil;
import com.hsy.result.Result;
import net.sf.json.JSONObject;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by HSY on 2017/7/7.
 */
public class ResultParam extends ReadExcelUtil {
    private ArrayList<JSONObject> result;
    private ArrayList<Integer> expCode;
    private ArrayList<String> expMessage ;
    private int rows;
    private ArrayList<Integer> actCode = new ArrayList<>();
    private ArrayList<String> actMessage = new ArrayList<>();

    public ResultParam(String casePath, int sheetIndex) throws IOException, ClassNotFoundException, NoSuchFieldException {
        super(casePath, sheetIndex);
        result = new Result(casePath, sheetIndex).testResult();
        expCode = super.getCodes();
        expMessage = super.getMessages();
        rows = super.getRows();
    }

    public ArrayList<Integer> actCode() {
        for (JSONObject aResult : result) {
            actCode.add(aResult.getInt("status"));
        }
        return actCode;
    }

    public ArrayList<String> actMessage() {
        for (JSONObject aResult : result) {
            actMessage.add(aResult.getString("message"));
        }
        return actMessage;
    }

    public ArrayList<Integer> expCode() {
        return expCode;
    }

    public ArrayList<String> expMessage() {
        return expMessage;
    }

    public int size() {
        return rows;
    }

//    public static Collection prepareData() throws IOException {
//        ResultParam resultParam = new ResultParam("test_case.xlsx", 0);
//        int size = resultParam.expCode.size();
//        Object[][] objects = new Object[size][4];
//        for (int i = 0; i < objects.length; i++) {
//            objects[i][0] = resultParam.expCode.get(i);
//            objects[i][1] = resultParam.actCode.get(i);
//            objects[i][2] = resultParam.expMessage.get(i);
//            objects[i][3] = resultParam.actMessage.get(i);
//        }
//        return Arrays.asList(objects);
//    }
}

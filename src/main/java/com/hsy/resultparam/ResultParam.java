package com.hsy.resultparam;

import com.hsy.readexcel.ReadExcelUtil;
import com.hsy.result.Result;
import net.sf.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by HSY on 2017/7/7.
 * 获取当前sheet的所有预期code，预期message，实际code，实际message，当前的行数
 */
public class ResultParam extends ReadExcelUtil {
    private ArrayList<JSONObject> result;
    private ArrayList<Integer> expCode;
    private ArrayList<String> expMessage;
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

}

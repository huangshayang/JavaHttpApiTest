package com.hsy.resultparam;

import com.hsy.result.Result;
import net.sf.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by HSY on 2017/7/7.
 */
public class ResultParam {
    private ArrayList<JSONObject> result;
    private ArrayList<Integer> code;
    private ArrayList<String> message ;
    private ArrayList<String> name;
    private ArrayList<Object> pa = new ArrayList<>();

    public ResultParam(String casePath, int sheetIndex) throws IOException {
        result = new Result(casePath, sheetIndex).testResult();
        code = new Result(casePath, sheetIndex).getCode();
        message = new Result(casePath, sheetIndex).getMessage();
        name = new Result(casePath, sheetIndex).getName();
    }

    public ArrayList<Object> value() {
        for (int i = 0; i < result.size(); i++) {
            pa.add(result.get(i).getInt("status"));
            pa.add(result.get(i).getString("message"));
            pa.add(code.get(i));
            pa.add(message.get(i));
            pa.add(name.get(i));
        }
        return pa;
    }
}

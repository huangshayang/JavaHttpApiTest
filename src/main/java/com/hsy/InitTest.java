package com.hsy;


import net.sf.json.JSONObject;
import java.util.HashMap;
import java.util.Iterator;



/**
 * Created by HSY on 2017/6/30.
 */
public class InitTest {
    private static HashMap<String, Object> toMap(String str) {
        HashMap<String, Object> data = new HashMap<String, Object>();
        // 将json字符串转换成jsonObject
        JSONObject jsonObject = JSONObject.fromObject(str);
        Iterator ite = jsonObject.keys();
        // 遍历jsonObject数据,添加到Map对象
        while (ite.hasNext()) {
            String key = ite.next().toString();
            Object value = jsonObject.get(key);
            data.put(key, value);
        }
        // 或者直接将 jsonObject赋值给Map
        // data = jsonObject;
        return data;
    }
    public static void main(String[] args) {
        String str = "{\"username\":\"13631260632\", \"password\":\"96e79218965eb72c92a549dd5a330112\"}";
//        System.out.println(toMap(str));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("=");
        str += stringBuffer;
        System.out.println(str);
    }
}

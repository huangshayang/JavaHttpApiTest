package com.hsy.result;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by HSY on 2017/7/3.
 */
public class ResultTest {
    @Test
    public void testResult() throws Exception {
        System.out.println(Result.testResult());
        assertEquals(Result.testResult().getInt("status"), 0);
        assertEquals(Result.testResult().getString("message"), "操作成功。");
    }
}
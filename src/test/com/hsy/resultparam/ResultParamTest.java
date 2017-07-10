package com.hsy.resultparam;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by HSY on 2017/7/7.
 */
public class ResultParamTest {
    @Test
    public void testValue() throws Exception {
        System.out.println(new ResultParam("test_case.xlsx", 0).value());
    }
}
package com.hsy.readexcel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by HSY on 2017/7/6.
 */
public class ReadExcelUtilTest {
    private ReadExcelUtil readExcelUtil;
    @Before
    public void setUp() throws Exception {
        readExcelUtil = new ReadExcelUtil("test_case.xlsx", 0);
    }
    @Test
    public void getRows() throws Exception {
        int rows = readExcelUtil.getRows();
        System.out.println(rows);
    }

    @Test
    public void getNames() throws Exception {
        ArrayList<String> xssfCellNames = readExcelUtil.getNames();
        System.out.println(xssfCellNames);
    }

    @Test
    public void getUrls() throws Exception {
        ArrayList<String> xssfCellUrls = readExcelUtil.getUrls();
        System.out.println(xssfCellUrls);
    }

    @Test
    public void getDatas() throws Exception {
        ArrayList<String> xssfCellDatas = readExcelUtil.getDatas();
        System.out.println(xssfCellDatas);
    }

    @Test
    public void getFiles() throws Exception {
        ArrayList<String> xssfCellFiles = readExcelUtil.getFiles();
        System.out.println(xssfCellFiles);
    }

    @Test
    public void getMethods() throws Exception {
        ArrayList<String> xssfCellMethods = readExcelUtil.getMethods();
        System.out.println(xssfCellMethods);
    }

    @Test
    public void getCodes() throws Exception {
        ArrayList<Integer> xssfCellCodes = readExcelUtil.getCodes();
        System.out.println(xssfCellCodes);
    }

    @Test
    public void getMessages() throws Exception {
    }

    @Test
    public void getTokens() throws Exception {
    }

}
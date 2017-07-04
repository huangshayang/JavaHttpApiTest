package com.hsy.readexcel;

import java.util.HashMap;

/**
 * Created by HSY on 2017/7/3.
 */
public class ReadExcel {
    private int[] sheets;
    private int rows;
    private int cols;
    private String[] urls;
    private String[] methods;
    private String[] datas;
    private HashMap<String, Object>[] params;
    private String[] files;
    private int[] codes;
    private int[] token;
    private String[] messages;
    private String[] names;
    private String path;

    public ReadExcel(String path){
        this.path = path;
    }

    public int[] getSheets() {
        path = "";
        return sheets;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public String[] getUrls() {
        return urls;
    }

    public void setUrls(String[] urls) {
        this.urls = urls;
    }

    public String[] getMethods() {
        return methods;
    }

    public void setMethods(String[] methods) {
        this.methods = methods;
    }

    public String[] getDatas() {
        return datas;
    }

    public void setDatas(String[] datas) {
        this.datas = datas;
    }

    public HashMap<String, Object>[] getParams() {
        return params;
    }

    public void setParams(HashMap<String, Object>[] params) {
        this.params = params;
    }

    public String[] getFiles() {
        return files;
    }

    public void setFiles(String[] files) {
        this.files = files;
    }

    public int[] getCodes() {
        return codes;
    }

    public void setCodes(int[] codes) {
        this.codes = codes;
    }

    public int[] getToken() {
        return token;
    }

    public void setToken(int[] token) {
        this.token = token;
    }

    public String[] getMessages() {
        return messages;
    }

    public void setMessages(String[] messages) {
        this.messages = messages;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }
}

package com.hsy.readexcel;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by HSY on 2017/7/6.
 */
public interface ReadExcelUtilInterface {
    int getRows() throws IOException;

    ArrayList<String> getNames() throws IOException;

    ArrayList<String> getUrls() throws IOException;

    ArrayList<String> getDatas() throws IOException;

    ArrayList<String> getFiles() throws IOException;

    ArrayList<String> getMethods() throws IOException;

    ArrayList<Integer> getCodes() throws IOException;

    ArrayList<String> getMessages() throws IOException;

    ArrayList<Integer> getTokens() throws IOException;

}

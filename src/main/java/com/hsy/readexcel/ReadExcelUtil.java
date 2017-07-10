package com.hsy.readexcel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by HSY on 2017/7/5.
 */
public class ReadExcelUtil implements ReadExcelUtilInterface {
    private String casePath;
    private int sheetIndex;
    private ArrayList<String> xssfCellNames = new ArrayList<>();
    private ArrayList<String> xssfCellUrls = new ArrayList<>();
    private ArrayList<String> xssfCellDatas = new ArrayList<>();
    private ArrayList<String> xssfCellFiles = new ArrayList<>();
    private ArrayList<String> xssfCellMethods = new ArrayList<>();
    private ArrayList<Integer> xssfCellCodes = new ArrayList<>();
    private ArrayList<String> xssfCellMessages = new ArrayList<>();
    private ArrayList<Integer> xssfCellTokens = new ArrayList<>();

    public ReadExcelUtil(String casePath, int sheetIndex) {
        this.casePath = casePath;
        this.sheetIndex = sheetIndex;
    }

    private XSSFSheet sheets() throws IOException {
        File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\hsy\\case\\" + casePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        return xssfWorkbook.getSheetAt(sheetIndex);
    }

    public int getRows() throws IOException {
        return sheets().getLastRowNum();
    }

    public ArrayList<String> getNames() throws IOException {
        for (int i = 1; i <= sheets().getLastRowNum(); i++) {
            xssfCellNames.add(parseCellStr(sheets().getRow(i).getCell(0)));
        }
        return xssfCellNames;
    }

    public ArrayList<String> getUrls() throws IOException {
        for (int i = 1; i <= sheets().getLastRowNum(); i++) {
            xssfCellUrls.add(parseCellStr(sheets().getRow(i).getCell(1)));
        }
        return xssfCellUrls;
    }

    public ArrayList<String> getDatas() throws IOException {
        for (int i = 1; i <= sheets().getLastRowNum(); i++) {
            xssfCellDatas.add(parseCellStr(sheets().getRow(i).getCell(2)));
        }
        return xssfCellDatas;
    }

    public ArrayList<String> getFiles() throws IOException {
        for (int i = 1; i <= sheets().getLastRowNum(); i++) {
            xssfCellFiles.add(parseCellStr(sheets().getRow(i).getCell(3)));
        }
        return xssfCellFiles;
    }

    public ArrayList<String> getMethods() throws IOException {
        for (int i = 1; i <= sheets().getLastRowNum(); i++) {
            xssfCellMethods.add(parseCellStr(sheets().getRow(i).getCell(4)));
        }
        return xssfCellMethods;
    }

    public ArrayList<Integer> getCodes() throws IOException {
        for (int i = 1; i <= sheets().getLastRowNum(); i++) {
            xssfCellCodes.add(parseCellInt(sheets().getRow(i).getCell(5)));
        }
        return xssfCellCodes;
    }

    public ArrayList<String> getMessages() throws IOException {
        for (int i = 1; i <= sheets().getLastRowNum(); i++) {
            xssfCellMessages.add(parseCellStr(sheets().getRow(i).getCell(6)));
        }
        return xssfCellMessages;
    }

    public ArrayList<Integer> getTokens() throws IOException {
        for (int i = 1; i <= sheets().getLastRowNum(); i++) {
            xssfCellTokens.add(parseCellInt(sheets().getRow(i).getCell(7)));
        }
        return xssfCellTokens;
    }

    private int parseCellInt(XSSFCell cell) {
        return (int) Double.parseDouble(cell.toString());
    }

    private String parseCellStr(XSSFCell cell) {
        if (cell == null) {
            return null;
        }
        return cell.toString();
    }
}
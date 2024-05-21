package com.lazyxu.renamehelp;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelHelper {

    public static void readExcel(String path){
        try {
            Workbook workbook = Workbook.getWorkbook(new File(path));
            Sheet sheet = workbook.getSheet(1);
            JSONArray jsonArray = new JSONArray();
            for(int i=1; i < sheet.getRows(); i++){
                JSONObject jsonObject = new JSONObject();
                Cell[] cells = sheet.getRow(i);
                jsonObject.put("id", cells[0].getContents());
                jsonObject.put("title", cells[1].getContents());
                jsonObject.put("content", cells[2].getContents());
                jsonArray.put(jsonObject);
            }
            System.out.println("json转换结果：" + jsonArray.toString());
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}

package test.ExcelTest;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.*;

public class GetExcelInfo {
    public static void main(String[] args) throws WriteException {
        GetExcelInfo obj = new GetExcelInfo();
        File file = new File("./src/main/java/test/ExcelTest/投控系统企业安全生产专家库导出版本.xls");
        readExcel(file);
        System.out.println("ok");
    }

    public static void readExcel(File file) throws WriteException {
        try {
            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(file.getAbsolutePath());
            WritableWorkbook book = Workbook.createWorkbook(file);
            WritableSheet sheet = book.createSheet("sheet", 0);
            sheet.mergeCells(0,0,10,0);
            Label label = new Label(0,0, "深圳市投资控股有限公司2014年11月专家库报名汇总表");
            sheet.addCell(label);
            label = new Label(0,1, "序号");
            sheet.addCell(label);
            label = new Label(1,1, "组别");
            sheet.addCell(label);
            label = new Label(2,1, "单位");
            sheet.addCell(label);
            label = new Label(3,1, "姓名");
            sheet.addCell(label);
            label = new Label(4,1, "性别");
            sheet.addCell(label);
            label = new Label(5,1, "出生日期");
            sheet.addCell(label);
            label = new Label(6,1, "职务职称");
            sheet.addCell(label);
            label = new Label(7,1, "学历");
            sheet.addCell(label);
            label = new Label(8,1, "专业");
            sheet.addCell(label);
            label = new Label(9,1, "现从事专业");
            sheet.addCell(label);
            label = new Label(10,1, "业务专长");
            sheet.addCell(label);
            label = new Label(11,1,"电话");
            sheet.addCell(label);
            label = new Label(12,1, "手机");
            sheet.addCell(label);

            for (int i = 2; i < 10; i++) {
                for (int j = 0; j < 12; j++) {
                    label = new Label(j, i, "This is a Label cell");
                    sheet.addCell(label);
                }
            }
            book.write();
            book.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package test.ExcelTest;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * Excel读取数据测试
 *
 * @author Administrator
 */
public class readData {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\nan\\maven\\demo\\src\\main\\java\\test\\ExcelTest\\test.xls");

        String[][] result = getData(file, 2);

        List<userModel> list = detectUserInf(result);

        System.out.println(list.size());
    }

    /**
     * 判定数据用的函数
     *
     * @param result
     * @return
     */
    public static List<userModel> detectUserInf(String[][] result) {

        int rowLength = result.length;

        List<userModel> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            userModel model = new userModel();
            for (int j = 0; j < result[i].length; j++) {
                switch (j) {
                    case 0:
                        if (!"".equals(result[i][j])) {
                            model.setUserId(Integer.parseInt(result[i][j]));
                        } else {
                            break;
                        }
                        break;
                    case 1:
                        if (!"".equals(result[i][j])) {
                            model.setGroupType(result[i][j]);
                        } else {
                            break;
                        }
                        break;
                    case 2:
                        if (!"".equals(result[i][j])) {
                            model.setUnit(result[i][j]);
                        } else {
                            break;
                        }
                        break;
                    case 3:
                        if (!"".equals(result[i][j])) {
                            model.setName(result[i][j]);
                        } else {
                            break;
                        }
                        break;
                    case 4:
                        if (!"".equals(result[i][j])) {
                            model.setGender(detectGender(result[i][j]));
                        } else {
                            break;
                        }
                        break;
                    case 5:
                        if (!"".equals(result[i][j])) {
                            model.setBirthData(result[i][j]);
                        } else {
                            break;
                        }
                        break;
                    case 6:
                        if (!"".equals(result[i][j])) {
                            model.setJobName(result[i][j]);
                        } else {
                            break;
                        }
                        break;
                    case 7:
                        if (!"".equals(result[i][j])) {
                            model.setEducation(result[i][j]);
                        } else {
                            break;
                        }
                        break;
                    case 8:
                        if (!"".equals(result[i][j])) {
                            model.setProfessional(result[i][j]);
                        } else {
                            break;
                        }
                        break;
                    case 9:
                        if (!"".equals(result[i][j])) {
                            model.setCurrentlyProfessional(result[i][j]);
                        } else {
                            break;
                        }
                        break;
                    case 10:
                        if (!"".equals(result[i][j])) {
                            model.setBusinessExpertise(result[i][j]);
                        } else {
                            break;
                        }
                        break;
                    case 11:
                        if (!"".equals(result[i][j])) {
                            model.setTelephone(result[i][j]);
                        } else {
                            break;
                        }
                        break;
                    case 12:
                        if (!"".equals(result[i][j])) {
                            model.setTelephone(result[i][j]);
                        } else {
                            break;
                        }
                        break;
                    case 13:
                        if (!"".equals(result[i][j])) {
                            model.setMobilePhone(result[i][j]);
                        } else {
                            break;
                        }
                        break;
                    default:
                        break;
                }

            }
            System.out.println(model.toString());
            if (model.noHaveEmpty()) {
                list.add(model);
            }
        }
        System.out.println(list.size());
        return list;
    }

    public static int detectGender(String gender){
        String man = "男";
        String woman = "女";
        if (man.equals(gender)){
            return 1;
        }
        if (woman.equals(gender)){
            return 2;
        }
        return 0;
    }

    /**
     * 读取Excel的内容，第一维数组存储的是一行中格列的值，二维数组存储的是多少个行
     *
     * @param file       读取数据的源Excel
     * @param ignoreRows 读取数据忽略的行数，比喻行头不需要读入 忽略的行数为1
     * @return 读出的Excel中数据的内容
     * @throws FileNotFoundException
     * @throws IOException
     */

    public static String[][] getData(File file, int ignoreRows)

            throws FileNotFoundException, IOException {

        List<String[]> result = new ArrayList<String[]>();

        int rowSize = 0;

        BufferedInputStream in = new BufferedInputStream(new FileInputStream(

                file));

        // 打开HSSFWorkbook

        POIFSFileSystem fs = new POIFSFileSystem(in);

        HSSFWorkbook wb = new HSSFWorkbook(fs);

        HSSFCell cell = null;

        for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {

            HSSFSheet st = wb.getSheetAt(sheetIndex);

            // 第一行为标题，不取

            for (int rowIndex = ignoreRows; rowIndex <= st.getLastRowNum(); rowIndex++) {

                HSSFRow row = st.getRow(rowIndex);

                if (row == null) {

                    continue;

                }

                int tempRowSize = row.getLastCellNum() + 1;

                if (tempRowSize > rowSize) {

                    rowSize = tempRowSize;

                }

                String[] values = new String[rowSize];

                Arrays.fill(values, "");

                boolean hasValue = false;

                for (short columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++) {

                    String value = "";

                    cell = row.getCell(columnIndex);

                    if (cell != null) {

                        switch (cell.getCellType()) {

                            case HSSFCell.CELL_TYPE_STRING:

                                value = cell.getStringCellValue();

                                break;

                            case HSSFCell.CELL_TYPE_NUMERIC:

                                if (HSSFDateUtil.isCellDateFormatted(cell)) {

                                    Date date = cell.getDateCellValue();

                                    if (date != null) {

                                        value = new SimpleDateFormat("yyyy-MM-dd")

                                                .format(date);

                                    } else {

                                        value = "";

                                    }

                                } else {

                                    value = new DecimalFormat("0").format(cell

                                            .getNumericCellValue());

                                }

                                break;

                            case HSSFCell.CELL_TYPE_FORMULA:

                                // 导入时如果为公式生成的数据则无值

                                if (!cell.getStringCellValue().equals("")) {

                                    value = cell.getStringCellValue();

                                } else {

                                    value = cell.getNumericCellValue() + "";

                                }

                                break;

                            case HSSFCell.CELL_TYPE_BLANK:

                                break;

                            case HSSFCell.CELL_TYPE_ERROR:

                                value = "";

                                break;

                            case HSSFCell.CELL_TYPE_BOOLEAN:

                                value = (cell.getBooleanCellValue() == true ? "Y"

                                        : "N");

                                break;

                            default:

                                value = "";

                        }

                    }

                    if (columnIndex == 0 && value.trim().equals("")) {

                        break;

                    }

                    values[columnIndex] = rightTrim(value);

                    hasValue = true;

                }


                if (hasValue) {

                    result.add(values);

                }

            }

        }

        in.close();

        String[][] returnArray = new String[result.size()][rowSize];

        for (int i = 0; i < returnArray.length; i++) {

            returnArray[i] = (String[]) result.get(i);

        }

        return returnArray;

    }


    /**
     * 去掉字符串右边的空格
     *
     * @param str 要处理的字符串
     * @return 处理后的字符串
     */

    public static String rightTrim(String str) {

        if (str == null) {

            return "";

        }

        int length = str.length();

        for (int i = length - 1; i >= 0; i--) {

            if (str.charAt(i) != 0x20) {

                break;

            }

            length--;

        }

        return str.substring(0, length);

    }

}

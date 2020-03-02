package com.liurui.util.common.office;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.converter.ExcelToHtmlConverter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ExcelUtils
 * @Description TODO
 * @Author liurui
 * @Date 2019/1/17 4:57 PM
 **/
public class ExcelUtils {

    public static void main(String[] args) {
        File file = new File("/Users/liurui/Downloads/共享空间/刘瑞_20180107－20180111研发部周工作计划.xls");
//        List<String> a = excel2HTML(file, "/Users/liurui/Downloads/test/preview/");
//        for (String s : a) {
//            System.out.println(s);
//        }
        System.exit(0);
    }


    public static String excel2HTML(File target, String absoluPath) {
        if (!target.exists() || StringUtils.isBlank(absoluPath)) {
            return null;
        }
        try {
            if (target.getName().endsWith(".xls")) {
                return xls2HTML(target, absoluPath);
            } else if (target.getName().endsWith(".xlsx")) {
                return xlsx2HTML(target, absoluPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    /**
     * excel03转html
     * filename:要读取的文件所在文件夹
     * filepath:文件名
     * htmlname:生成html名称
     * path:html存放路径
     * */
    private static String xls2HTML (File target, String absoluPath) throws Exception {
        List<String> list = new ArrayList<>();
        String htmlname="exportExcel_" + target.getName().substring(target.getName().indexOf(".")) + ".html";
        fileExists(absoluPath);
        InputStream input=new FileInputStream(target);

        HSSFWorkbook excelBook=new HSSFWorkbook(input);
        ExcelToHtmlConverter excelToHtmlConverter = new ExcelToHtmlConverter (DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument() );
        excelToHtmlConverter.processWorkbook(excelBook);//excel转html
        Document htmlDocument =excelToHtmlConverter.getDocument();
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();//字节数组输出流
//        return outStream.toString();
        DOMSource domSource = new DOMSource(htmlDocument);
        StreamResult streamResult = new StreamResult(outStream);
        /** 将document中的内容写入文件中，创建html页面 */
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer serializer = tf.newTransformer();
        serializer.setOutputProperty (OutputKeys.ENCODING, "utf-8");
        serializer.setOutputProperty (OutputKeys.INDENT, "yes");
        serializer.setOutputProperty (OutputKeys.METHOD, "html");
        serializer.transform (domSource, streamResult);
        outStream.close();
        String content = new String(outStream.toString("UTF-8"));

        return content;

//        FileUtils.writeStringToFile(new File (absoluPath, htmlname), content, "utf-8");
//        list.add(absoluPath + htmlname);
//        return list;
    }


    /**
     * excel07转html
     * filename:要读取的文件所在文件夹
     * filepath:文件名
     * htmlname:生成html名称
     * path:html存放路径
     * */
    private static String xlsx2HTML (File target, String absoluPath) throws Exception {
        List<String> list = new ArrayList<>();
        String htmlname="exportExcel_" + target.getName().substring(target.getName().indexOf(".")) + ".html";
        fileExists(absoluPath);
        InputStream input=new FileInputStream(target);
        Workbook workbook = null;
        InputStream is = new FileInputStream(target);
        try {
            StringBuilder html= new StringBuilder();
            workbook =  new XSSFWorkbook(is);
            for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
                Sheet sheet = workbook.getSheetAt(numSheet);
                if (sheet == null) {
                    continue;
                }
                html.append("=======================").append(sheet.getSheetName()).append("=========================<br><br>");

                int firstRowIndex = sheet.getFirstRowNum();
                int lastRowIndex = sheet.getLastRowNum();
                html.append("<table border='1' align='left'>");
                Row firstRow = sheet.getRow(firstRowIndex);
                for (int i = firstRow.getFirstCellNum(); i <= firstRow.getLastCellNum(); i++) {
                    Cell cell = firstRow.getCell(i);
                    String cellValue = getCellValue(cell, true);
                    html.append("<th>").append(cellValue).append("</th>");
                }

                //行
                for (int rowIndex = firstRowIndex + 1; rowIndex <= lastRowIndex; rowIndex++) {
                    Row currentRow = sheet.getRow(rowIndex);
                    html.append("<tr>");
                    if(currentRow!=null){

                        int firstColumnIndex = currentRow.getFirstCellNum();
                        int lastColumnIndex = currentRow.getLastCellNum();
                        //列
                        for (int columnIndex = firstColumnIndex; columnIndex <= lastColumnIndex; columnIndex++) {
                            Cell currentCell = currentRow.getCell(columnIndex);
                            String currentCellValue = getCellValue(currentCell, true);
                            html.append("<td>").append(currentCellValue).append("</td>");
                        }
                    }else{
                        html.append(" ");
                    }
                    html.append("</tr>");
                }
                html.append("</table>");


//                ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//                DOMSource domSource = new DOMSource ();
//                StreamResult streamResult = new StreamResult (outStream);
//
//                TransformerFactory tf = TransformerFactory.newInstance();
//                Transformer serializer = tf.newTransformer();
//                serializer.setOutputProperty (OutputKeys.ENCODING, "utf-8");
//                serializer.setOutputProperty (OutputKeys.INDENT, "yes");
//                serializer.setOutputProperty (OutputKeys.METHOD, "html");
//                serializer.transform (domSource, streamResult);
//                outStream.close();
//                FileUtils.writeStringToFile(new File (absoluPath, htmlname), html.toString(), "gbk");
//                list.add(absoluPath + htmlname);
            }
            return html.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 读取单元格
     *
     */
    private static String getCellValue(Cell cell, boolean treatAsStr) {
        if (cell == null) {
            return "";
        }

        if (treatAsStr) {
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }

        if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            return String.valueOf(cell.getNumericCellValue());
        } else {
            return String.valueOf(cell.getStringCellValue());
        }
    }

    private static void fileExists(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
    }


}

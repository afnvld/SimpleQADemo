package excelData;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;

public class ExcelDemo {

    public static void main(String[] args) throws IOException, InvalidFormatException {
        String excelPath = "/Users/j/Desktop/apiTesting/src/main/resources/ExcelData.xlsx";

        Workbook book = WorkbookFactory.create(new File(excelPath));

        System.out.println(book.getNumberOfSheets());
        Sheet sheet = book.getSheetAt(0);
        System.out.println(sheet.getSheetName());
        for(Row row: sheet){
            for(Cell cell: row){
                System.out.println(cell);
            }
        }

    }
}

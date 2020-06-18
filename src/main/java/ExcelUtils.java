import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {

    static XSSFWorkbook workBook;
    static XSSFSheet workSheet;

    public ExcelUtils(String excelPath, String sheetName) {
        try {
            workBook = new XSSFWorkbook(excelPath);
            workSheet = workBook.getSheet(sheetName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getRowCount(){
        int rowCount = 0;
        rowCount = workSheet.getPhysicalNumberOfRows();
        System.out.println("Row Count=" + rowCount);
        return rowCount;
    }

    public static int getColumnCount(){
        int columnCount = 0;
        columnCount = workSheet.getRow(0).getPhysicalNumberOfCells();
        System.out.println("ColumnCount="+ columnCount);
        return columnCount;
    }

    public String getCellData(int rowNum, int columnNum){
        DataFormatter dataFormatter = new DataFormatter();
        String cellValue = dataFormatter.formatCellValue(workSheet.getRow(rowNum).getCell(columnNum));
        System.out.println("Cell Value ="+ cellValue);
        return cellValue;
    }

}

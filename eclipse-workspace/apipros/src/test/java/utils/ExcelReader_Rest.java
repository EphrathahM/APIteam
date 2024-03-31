package utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class ExcelReader_Rest {

	public static List<Map<String, String>> getData(String excelFilePath, String sheetName)
            throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(new File(excelFilePath));
        Sheet sheet = workbook.getSheet(sheetName);
        List<Map<String, String>> data = readSheet(sheet);
        workbook.close(); // Close the workbook after reading the sheet
        return data;
    }

    private static List<Map<String, String>> readSheet(Sheet sheet) {
        int startRow = 1; // Index of the first row (row 1 in Excel)
        int endRow = sheet.getLastRowNum(); // Index of the last row

        List<Map<String, String>> excelRows = new ArrayList<>();
        DataFormatter dataFormatter = new DataFormatter();

        Row headerRow = sheet.getRow(0); // Header row

        for (int currentRow = startRow; currentRow <= endRow; currentRow++) {
            Row row = sheet.getRow(currentRow);

            if (row != null) {
                LinkedHashMap<String, String> columnMapData = new LinkedHashMap<>();

                int totalColumn = headerRow.getLastCellNum();

                for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
                    Cell cell = row.getCell(currentColumn);

                    if (cell != null) {
                        String columnHeaderName = headerRow.getCell(currentColumn).getStringCellValue();
                        String cellValue = dataFormatter.formatCellValue(cell);

                        // Replace "null" string with Java null
                        if (cellValue.equals("null")) {
                            cellValue = null;
                        }

                        columnMapData.put(columnHeaderName, cellValue);
                    } else {
                        // Handle the case when the cell is null, set the value to null
                        String columnHeaderName = headerRow.getCell(currentColumn).getStringCellValue();
                        columnMapData.put(columnHeaderName, null);
                    }
                }

                excelRows.add(columnMapData);
            }
        }

        return excelRows;
    }
}

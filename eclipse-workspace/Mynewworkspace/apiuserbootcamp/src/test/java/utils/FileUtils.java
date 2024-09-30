package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileUtils {

	
	
	 public static ResourceBundle paths= ResourceBundle.getBundle("path");
	 static DataFormatter dataFormatter = new DataFormatter();
	
	
	public static List<LinkedHashMap<String, String>> getExcelDataAsListOfMap(String sheetName) throws IOException {
		List<LinkedHashMap<String, String>> dataFromExcel = new ArrayList<>();

		String filePath = System.getProperty("user.dir") + paths.getString("excelfilepath");
		File file = new File(filePath);
		if (!file.exists()) {
			throw new RuntimeException("File not found at: " + filePath);
		}

		try (XSSFWorkbook workbook = new XSSFWorkbook(filePath)) {
			XSSFSheet sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				throw new RuntimeException("Sheet not found: " + sheetName);
			}

			int totalRows = sheet.getPhysicalNumberOfRows();
			LinkedHashMap<String, String> mapData;
			List<String> allKeys = new ArrayList<>();

			for (int i = 0; i < totalRows; i++) {
				mapData = new LinkedHashMap<>();
				if (i == 0) {
					int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();
					for (int j = 0; j < totalCols; j++) {
						allKeys.add(sheet.getRow(0).getCell(j).getStringCellValue());
					}
				} else {
					int totalCols = sheet.getRow(i).getPhysicalNumberOfCells();
					for (int j = 0; j < totalCols; j++) {
						String cellValue = dataFormatter.formatCellValue(sheet.getRow(i).getCell(j));
						mapData.put(allKeys.get(j), cellValue);
					}
					dataFromExcel.add(mapData);
				}
			}
		}

		return dataFromExcel;
	}
	
	
	
	
}



package com.shiftservices.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;

import com.shiftservices.dto.ShiftEntryDTO;

public class ShiftDataExcelWriter {

/*	public static File write1(String fileName, List<ShiftEntryDTO> dtos) {

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("All Employees Shift Data Report");

		Map<String, Object[]> data = new HashMap<String, Object[]>();
		//data.put("1", new Object[] {"Emp No.", "Name", "Salary"});
		data.put("2", new Object[] {1d, "John", 1500000d});
		data.put("3", new Object[] {2d, "Sam", 800000d});
		data.put("4", new Object[] {3d, "Dean", 700000d});
		
		Set<String> keyset = data.keySet();
		int rownum = 1;
		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof Date)
					cell.setCellValue((Date) obj);
				else if (obj instanceof Boolean)
					cell.setCellValue((Boolean) obj);
				else if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Double)
					cell.setCellValue((Double) obj);
			}
		}

		sheet.shiftRows(2, sheet.getLastRowNum(), 1); // shift rows to bottom
		Row row = sheet.createRow(1);
		Object[] objHeaders = new Object[] {"Emp No.", "Name", "Salary"};
		int cellnum = 0;
		for (Object obj : objHeaders) {
			Cell cell = row.createCell(cellnum++);
			if (obj instanceof Date)
				cell.setCellValue((Date) obj);
			else if (obj instanceof Boolean)
				cell.setCellValue((Boolean) obj);
			else if (obj instanceof String)
				cell.setCellValue((String) obj);
			else if (obj instanceof Double)
				cell.setCellValue((Double) obj);
		}
		
		
		File file = new File(fileName);

		try {

			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);
			out.close();
			SysLogger.logMethod("write", "Excel written successfully..");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return file;

	}*/
	
	public static File write(String fileName, List<ShiftEntryDTO> dtos) {

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("All Employees Shift Data Report");
	    HSSFCellStyle    headerStyle = workbook.createCellStyle();
		HSSFFont headerFont = workbook.createFont();
        headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);

        headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        headerStyle.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
        headerStyle.setFillBackgroundColor(HSSFColor.WHITE.index);
        headerStyle.setFont(headerFont);
        

        HSSFRow row = sheet.createRow(0);

        HSSFCell cell0 = row.createCell(0);
        cell0.setCellStyle(headerStyle);
        cell0.setCellValue("EMPLOYEE ID");

        HSSFCell cell1 = row.createCell(1);
        cell1.setCellStyle(headerStyle);
        cell1.setCellValue("EMPLOYEE NAME");

        HSSFCell cell2 = row.createCell(2);
        cell2.setCellStyle(headerStyle);
        cell2.setCellValue("GRADE");

        HSSFCell cell3 = row.createCell(3);
        cell3.setCellStyle(headerStyle);
        cell3.setCellValue("SHIFTTYPE");

        HSSFCell cell4 = row.createCell(4);
        cell4.setCellStyle(headerStyle);
        cell4.setCellValue("TIMEPERIOD");
        
        HSSFCell cell5 = row.createCell(5);
        cell5.setCellStyle(headerStyle);
        cell5.setCellValue("NO OF SHIFT DAYS");

        HSSFCell cell6 = row.createCell(6);
        cell6.setCellStyle(headerStyle);
        cell6.setCellValue("SHIFTALLOWANCE AMOUNT");
        
        HSSFCell cell7 = row.createCell(7);
        cell7.setCellStyle(headerStyle);
        cell7.setCellValue("ON CALL WEEKDAYS");

        HSSFCell cell8 = row.createCell(8);
        cell8.setCellStyle(headerStyle);
        cell8.setCellValue("ON CALL WEEKENDS");

        HSSFCell cell9 = row.createCell(9);
        cell9.setCellStyle(headerStyle);
        cell9.setCellValue("TOTAL ON CALL ALLOWANCE AMOUNT");

        HSSFCell cell10 = row.createCell(10);
        cell10.setCellStyle(headerStyle);
        cell10.setCellValue("GRAND TOTAL ALLOWANCE AMOUNT");

		Map<String, Object[]> data = new HashMap<String, Object[]>();
		
		int index = 1;
		
		for (ShiftEntryDTO shiftEntryDTO : dtos) {
			data.put(
					String.valueOf(index++),
					new Object[] {
							shiftEntryDTO.getEmployeeId(),
							shiftEntryDTO.getEmployeeName(),
							shiftEntryDTO.getGrade().name(),
							shiftEntryDTO.getShiftType().name(),
							shiftEntryDTO.getTimePeriod().name(),
							format(shiftEntryDTO.getNoOfShiftDays()),
							format(shiftEntryDTO.getTotalShiftAllowanceAmount()),
							format(shiftEntryDTO.getNoOfOnCallWeekdays()),
							format(shiftEntryDTO.getNoOfOnCallWeekends()),
							format(shiftEntryDTO.getTotalOnCallAllowanceAmount()),
							format(shiftEntryDTO.getTotalAllowance()) });
		}
		
		Set<String> keyset = data.keySet();
		int rownum = 2;
		for (String key : keyset) {
			Row nextrow  = sheet.createRow(rownum++);
			Object[] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = nextrow.createCell(cellnum++);
				if (obj instanceof Date)
					cell.setCellValue((Date) obj);
				else if (obj instanceof Boolean)
					cell.setCellValue((Boolean) obj);
				else if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Double)
					cell.setCellValue((Double) obj);
			}
		}
		
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
		sheet.autoSizeColumn(3);
		sheet.autoSizeColumn(4);
		sheet.autoSizeColumn(5);
		sheet.autoSizeColumn(6);
		sheet.autoSizeColumn(7);
		sheet.autoSizeColumn(8);
		sheet.autoSizeColumn(9);
		sheet.autoSizeColumn(10);
		sheet.autoSizeColumn(11);
		
		File file = new File(fileName);

		try {

			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);
			out.close();
			SysLogger.logMethod("write", "Excel written successfully..");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return file;

	}
	
	private static String format(long l) {
		return String.valueOf(l);
	}

}

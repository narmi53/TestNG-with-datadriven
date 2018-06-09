package datadrivenexcel;

	import java.io.File;
	import java.io.FileInputStream;
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.List;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelHelper {
	public static HashMap<String,String> storeValues = new HashMap();
	public static List<HashMap<String,String>> getData(String filepath,String sheetName)
	{
	List<HashMap<String,String>> mydata = new ArrayList<>();
	try
	{
	FileInputStream fs = new FileInputStream(filepath);
	XSSFWorkbook workbook = new XSSFWorkbook(fs);
	XSSFSheet sheet = workbook.getSheet(sheetName);
	Row HeaderRow = sheet.getRow(0);
	for(int i=1;i<sheet.getPhysicalNumberOfRows();i++)
	{
	Row currentRow = sheet.getRow(i);
	HashMap<String,String> currentHash = new HashMap<String,String>();
	for(int j=0;j<currentRow.getPhysicalNumberOfCells();j++)
	{
	Cell currentCell = currentRow.getCell(j);
	switch (currentCell.getCellType())
	{
	case Cell.CELL_TYPE_STRING:
	//System.out.print(currentCell.getStringCellValue() + "\t");
	currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
	break;
	case Cell.CELL_TYPE_NUMERIC:
	int val = (int)currentCell.getNumericCellValue();
	                String cellvalue= String.valueOf(val);
	              //  System.out.print(currentCell.getStringCellValue() + "\t");
	currentHash.put(HeaderRow.getCell(j).getStringCellValue(), cellvalue);
//		currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.toString());
	break;
	default:
	break;
	}
	}
	mydata.add(currentHash);
	}
	fs.close();
	}
	catch (Exception e)
	{
	e.printStackTrace();
	}
	return mydata;
	}
	public static int getRowCount(String filepath,String sheetName)
	{
	int rowCount = 0;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	Row HeaderRow;
	try
	{
	FileInputStream fs = new FileInputStream(filepath);
	workbook = new XSSFWorkbook(fs);
	sheet = workbook.getSheet(sheetName);
	HeaderRow = sheet.getRow(0);
	  rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
	    System.out.println("Row cont:" + rowCount);
	}
	catch (Exception e)
	{
	e.printStackTrace();
	}
	return rowCount;
	}
	}


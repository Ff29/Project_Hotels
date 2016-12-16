package utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class TestDataProvider {
    
    @SuppressWarnings("deprecation")
	public static Object [][]getExcelData(String filePath, String SheetName) throws Exception{
        
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook wb= new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet(SheetName);
        
        int totalNoOfRows= sheet.getLastRowNum()+1;
        System.out.println(totalNoOfRows);
        int totalNoOfCol= sheet.getRow(0).getLastCellNum();
        System.out.println(totalNoOfCol);
        String [][]data= new String[totalNoOfRows][totalNoOfCol];
            for(int i=0;i<totalNoOfRows;i++){
                    for(int j=0;j<totalNoOfCol;j++){
                XSSFCell cell=    sheet.getRow(i).getCell(j);
            cell.setCellType(1);
                String value= cell.getStringCellValue();
                data[i][j]=value;
            }
        }
       return (data);
    }

    @DataProvider(name="loginDataSheet")
    public Object[][]loginData() throws Exception{
    	Object [][]arrayObject=getExcelData("ExcelTestDataSheets/number.xlsx","sheet1");
    	return arrayObject;
    }
}

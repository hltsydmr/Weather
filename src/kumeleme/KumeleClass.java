package kumeleme;
//import java.awt.Label;
import java.io.File;
import java.io.IOException;

import Utilities.Functions;
import jxl.Cell;
import jxl.CellFeatures;
import jxl.CellType;
import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.read.biff.BiffException;
import jxl.read.biff.PasswordException;
import jxl.write.WritableCell;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Label;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
public class KumeleClass {
	
	private Sheet sheetRead ;
	private WritableSheet sheetWrite;
	private int number ;
	WritableWorkbook workbook;
	
	public void init() throws BiffException, IOException{
		
		
		workbook = Workbook.createWorkbook(new File("kume.xlt"));
		sheetRead = Functions.readExcel("capstone.xlt");
		number = 10;
		sheetWrite = workbook.createSheet("fs",0);
	}
	
	public void translate() throws IOException, RowsExceededException, WriteException, BiffException{

		//Workbook w = Workbook.getWorkbook(new File("capstone.xlt"));
		//Sheet sheetRead = w.getSheet(0);
		
		for (int i = 1; i < 1818; i++) {
			
			for (int a=0;a<10;a++){

				//String word = sheetRead.getCell(3,i).getContents().toString()+sheetRead.getCell(3,i+1).getContents().toString()+sheetRead.getCell(3,i+2).getContents().toString()+sheetRead.getCell(3,i+3).getContents().toString()+sheetRead.getCell(3,i+4).getContents().toString()+sheetRead.getCell(3,i+5).getContents().toString()+sheetRead.getCell(3,i+6).getContents().toString()+sheetRead.getCell(3,i+7).getContents().toString()+sheetRead.getCell(3,i+8).getContents().toString()+sheetRead.getCell(3,i+9).getContents().toString();
				//System.out.println(word);
				String word =sheetRead.getCell(3,i+a).getContents();
				Label l=new Label(a,i,word);
				
				sheetWrite.addCell(l);
			}
			
			
			
			
			/*
			String word = sheetRead.getCell(3,i).toString()+sheetRead.getCell(3,i+1).toString()+sheetRead.getCell(3,i+2).toString()+sheetRead.getCell(3,i+3).toString()+sheetRead.getCell(3,i+4).toString()+sheetRead.getCell(3,i+5).toString()+sheetRead.getCell(3,i+6).toString()+sheetRead.getCell(3,i+7).toString()+sheetRead.getCell(3,i+8).toString()+sheetRead.getCell(3,i+9).toString();
			WritableWorkbook copy = Workbook.createWorkbook("capstone.xlt");
			Label lb=new Label();
			
			WritableCell wCell = new sheetWrite.WritableCell(0,0);
			
			wCell.setCellFormat((CellFormat) new Label());	
			
			Cell cl=word;
			sheetWrite.addCell(word);
		*/
		}
		workbook.write();
		workbook.close();
		
	}
	public KumeleClass() throws BiffException, IOException, RowsExceededException, WriteException{
		
		init();
		translate();
		
	}
	
}

package kumeleme;

import java.io.BufferedWriter;
import java.io.IOException;

import Utilities.Functions;
import jxl.Sheet;
import jxl.read.biff.BiffException;

public class writeARFF_2 {
	
	private Sheet sheetRead;

	public void writeTxt() throws IOException, BiffException{ 
		
		sheetRead = Functions.readExcel("BI_2.xlt");
		BufferedWriter bf = Functions.writeWord("txtARFF_2.txt");
	
		for (int i = 1; i < 731; i++) {
		
			String word="";
		
			for (int a=0;a<6;a++){

				if(a==5){
					word =word+sheetRead.getCell(a,i).getContents();
				}else{
					word =word+sheetRead.getCell(a,i).getContents()+",";
				}
				
			
			}
			bf.write(word);
			bf.newLine();
			System.out.println(word);
		}
		bf.close();
	
	}
	public writeARFF_2() throws BiffException, IOException{
		writeTxt();
	}
}

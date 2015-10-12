package kumeleme;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import jxl.Sheet;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import Utilities.Functions;

public class writeARFF {
	
	private Sheet sheetRead;
	
	public void writeTxt() throws IOException, BiffException{ 
	
		sheetRead = Functions.readExcel("kume.xlt");
		BufferedWriter bf = Functions.writeWord("txtARFF.txt");
	
		for (int i = 1; i < 1818; i++) {
		
			String word="";
		
			for (int a=0;a<10;a++){

				if(a==9){
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
	
	public writeARFF() throws BiffException, IOException{
		writeTxt();
	}
}

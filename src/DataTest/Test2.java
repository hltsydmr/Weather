package DataTest;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import Utilities.Weather_GUI;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class Test2 {

	public String findMax(String wrrd){
		float number1=Excel2.probhash.get(wrrd+"G");
		float number2=Excel2.probhash.get(wrrd+"Y");
		float number3=Excel2.probhash.get(wrrd+"K");
		
		if(number1 > number2){
			if(number1 > number3)
				return wrrd+"G";
			else
				return wrrd+"K";
		}
		else{
			if(number2>number3)
				return wrrd+"Y";
			else
				return wrrd+"K";
		} 
		
	}
	
	
	public Test2() throws BiffException, IOException{
		
		int tr=0;
		int fl=0;
		
		Workbook w1 = Workbook.getWorkbook(new File("capstone.xlt"));
		Sheet sh1 = w1.getSheet(0);
	
		for(int i=1461;i<1825;i++){
			String wrd;
		wrd = sh1.getCell(3,i).getContents().toString();
		
			if((wrd+sh1.getCell(3,i+1).getContents().toString()).equals(findMax(wrd))){
				tr++;
			}
			else{
				fl++;
			}
		}
		
		System.out.println("true:"+tr+"\nfalse:"+fl);
		System.out.println(((double) tr/(tr+fl))*100+" %");
		Weather_GUI.txt.append("true:"+tr+"\nfalse:"+fl+"\n");
		Weather_GUI.txt.append(((double) tr/(tr+fl))*100+" %"+"\n");
	}
}

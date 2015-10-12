package DataTest;
import java.io.File;
import java.io.IOException;

import Utilities.Weather_GUI;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class Test3 {

	public String findMax(String wrrd2)
	{
		float number1=Excel3.alist.get(wrrd2+"G");
		float number2=Excel3.alist.get(wrrd2+"Y");
		float number3=Excel3.alist.get(wrrd2+"K");
		
		if(number1 > number2)
		{
			if(number1 > number3)
				return wrrd2+"G";
			
			else
				return wrrd2+"K";
		}
		
		else
		{
			if(number2>number3)
				return wrrd2+"Y";
			
			else
				return wrrd2+"K";
		} 
		
	}
	

	public Test3() throws BiffException, IOException
	{
		
		int tr=0;
		int fl=0;
		
		Workbook w1 = Workbook.getWorkbook(new File("capstone.xlt"));
		Sheet sh1 = w1.getSheet(0);
		
		for(int i=1461;i<1825;i++)
		{
			String wrd;
			wrd = sh1.getCell(3,i).getContents().toString()+sh1.getCell(3,i+1).getContents().toString();
		
			if((wrd+sh1.getCell(3,i+2).getContents().toString()).equals(findMax(wrd)))
			{
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

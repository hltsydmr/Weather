package Predict;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import Utilities.Functions;
import Utilities.Weather_GUI;
import jxl.Cell;
import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.read.biff.PasswordException;


public class predictFuture {
	
	public static Hashtable<String, Integer> hash = new Hashtable<>();
	public static Hashtable<String, Float> probhash = new Hashtable<>();
	
	public void Read() throws BiffException, IOException{
		
		Workbook w = Workbook.getWorkbook(new File("capstone.xlt"));
		Sheet sh = w.getSheet(0);
		
		Workbook w2 = Workbook.getWorkbook(new File("liste.xlt"));
		Sheet sh2 = w2.getSheet(0);
		
		String word=null;
		
		for (int i = 0; i < 9; i++) {
			
			hash.put(sh2.getCell(3,i).getContents().toString(), 0);
			
		}
		
		for(int i=3;i<1455;i++)
		{
			
			word = sh.getCell(3,i).getContents().toString()+sh.getCell(3,i+4).getContents().toString();
			hash.put(word,hash.get(word)+1);
			
		}
		
		String q_1=null;
		String q_2=null;

		for(int b = 0;b < 3;b++ )
		{
			
			q_1=null;
			
			if(b==0)
				q_1="G";
			else if(b==1)
				q_1="Y";
			else if(b==2)
				q_1="K";
			
			
			for(int c=0;c<3;c++)
			{
				
				q_2=null;
				q_2=q_1;
				
				if(c==0)
					q_2=q_1+"G";
				else if(c==1)
					q_2=q_1+"Y";
				else if(c==2)
					q_2=q_1+"K";
				
				
					probhash.put(q_2,(float) hash.get(q_2)/(hash.get(q_1+"G")+hash.get(q_1+"Y")+hash.get(q_1+"K")));
									
			}
		}
		
			probhash = Functions.getSquareOfMatrixHashtable(probhash);
			
		
		
		
		for (int k = 0; k < 9; k++) {
			
			Weather_GUI.txt.append((sh2.getCell(3,k).getContents().toString()+" is :"+probhash.get(sh2.getCell(3,k).getContents()))+"\n");
		}
		
	}
	public predictFuture() throws BiffException, IOException{
		
		Read();
		new predictFutureTest();
		
	}
}

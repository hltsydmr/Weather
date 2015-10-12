package DataTest;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream.PutField;
import java.util.ArrayList;
import java.util.Hashtable;

import Utilities.Functions;
import Utilities.Weather_GUI;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class Excel3 {
	
	
	static Hashtable< String , Integer > hash = new Hashtable< String , Integer >();
	static Hashtable< String , Float > alist = new Hashtable< String , Float >();
	
	public void Read()
	{
		
		try {
			Sheet sh = Functions.readExcel("capstone.xlt");
			//Workbook w = Workbook.getWorkbook(new File("capstone.xlt"));
			//Sheet sh = w.getSheet(0);
			Sheet sh2 = Functions.readExcel("liste.xlt");
			//Workbook w2 = Workbook.getWorkbook(new File("liste.xlt"));
			//Sheet sh2 = w2.getSheet(0);
			
			String word;
			
			for(int k=0;k<27;k++)
			{
				
				hash.put(sh2.getCell(0,k).getContents().toString(), 0);
				
			}
			
			for(int i=3;i<1458;i++)
			{
				
				word = sh.getCell(3,i).getContents().toString()+sh.getCell(3,i+1).getContents().toString()+sh.getCell(3,i+2).getContents().toString();
				hash.put(word,hash.get(word)+1);
				
			}
				/*
				if((sh.getCell(3,i).getContents()).toString().equals("Y")){
	
					if((sh.getCell(3,i+1).getContents()).toString().equals("Y")){
						
						YY++;
						
					}
					else{
						
					}
				}
				else{
					
				}
			*/
				
			
			/*
			int ggTop = hash.get("GGG")+hash.get("GGY")+hash.get("GGK");
			int gyTop = hash.get("GYG")+hash.get("GYY")+hash.get("GYK");
			int gkTop = hash.get("GKG")+hash.get("GKY")+hash.get("GKK");
			int ygTop = hash.get("YGG")+hash.get("YGY")+hash.get("YGK");
			int yyTop = hash.get("YYG")+hash.get("YYY")+hash.get("YYK");
			int ykTop = hash.get("YKG")+hash.get("YKY")+hash.get("YKK");
			int kgTop = hash.get("KGG")+hash.get("KGY")+hash.get("KGK");
			int kyTop = hash.get("KYG")+hash.get("KYY")+hash.get("KYK");
			int kkTop = hash.get("KKG")+hash.get("KKY")+hash.get("KKK");
			*/
	
			String q_1=null;
			String q_2=null;
			String q_3=null;
	
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
					
					
					for(int d=0;d<3;d++)
					{
						
						q_3=null;
						q_3=q_2;
						
						if(d==0)
							q_3=q_2+"G";
						else if(d==1)
							q_3=q_2+"Y";
						else if(d==2)
							q_3=q_2+"K";
						
						alist.put(q_3,(float) hash.get(q_3)/(hash.get(q_2+"G")+hash.get(q_2+"Y")+hash.get(q_2+"K")));
						
					}
					
				}
			}
			
			//sh2.getCell(0,k).getContents().toString()+"\n")
			//System.out.println(alist.get("GGG"));
			
			//String yazdirBuilder = new String();
			
			for(int k=0;k<27;k++)
			{
				//cýktý.append((sh2.getCell(0,k).getContents().toString()+"is :"+alist.get(sh2.getCell(0,k).getContents().toString()+"\n")).toString());
				System.out.println((sh2.getCell(0,k).getContents().toString()+" is :"+alist.get(sh2.getCell(0,k).getContents())));
				Weather_GUI.txt.append((sh2.getCell(0,k).getContents().toString()+" is :"+alist.get(sh2.getCell(0,k).getContents()))+"\n");
			
			}
				
		} 
		catch (BiffException | IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	
	public Excel3() throws BiffException, IOException
	{
		
		Read();
		new Test3();
		
	}
	

}

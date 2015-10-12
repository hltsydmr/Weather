package DataTest;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import Utilities.Functions;
import Utilities.Weather_GUI;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class Excel4 {

	static Hashtable< String , Integer > hash = new Hashtable< String , Integer >();
	static Hashtable< String , Float > alist = new Hashtable< String , Float >();
	
	public void Read()
	{
		try {
			
			Sheet sh = Functions.readExcel("capstone.xlt");
			Sheet sh2 = Functions.readExcel("liste.xlt");
			
			String word;
			
			
			for(int k=0;k<81;k++)
			{
				
				hash.put(sh2.getCell(1,k).getContents().toString(), 0);
				
			}
			
			for(int i=3;i<1457;i++)
			{
				
				word = sh.getCell(3,i).getContents().toString()+sh.getCell(3,i+1).getContents().toString()+sh.getCell(3,i+2).getContents().toString()+sh.getCell(3,i+3).getContents().toString();
				hash.put(word,hash.get(word)+1);
		
			}
			
			String q_1=null;
			String q_2=null;
			String q_3=null;
			String q_4=null;
	
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
						
						
						for(int e=0;e<3;e++)
						{
							
							q_4=null;
							q_4=q_3;
							
							if(e==0)
								q_4=q_3+"G";
							else if(e==1)
								q_4=q_3+"Y";
							else if(e==2)
								q_4=q_3+"K";
							
							alist.put(q_4,(float) hash.get(q_4)/(hash.get(q_3+"G")+hash.get(q_3+"Y")+hash.get(q_3+"K")));
							
						}
						
						
					}
					
				}
			}
			
			
			for(int k=0;k<81;k++)
			{
				System.out.println((sh2.getCell(1,k).getContents().toString()+" is :"+alist.get(sh2.getCell(1,k).getContents())));
				Weather_GUI.txt.append((sh2.getCell(1,k).getContents().toString()+" is :"+alist.get(sh2.getCell(1,k).getContents()))+"\n");
			}
				
			
		} catch (BiffException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	public Excel4() throws BiffException, IOException
	{
		Read();
		new Test4();
	}
	
}

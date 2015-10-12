package DataTest;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import Utilities.Weather_GUI;
import Utilities.variableDay;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class Excel2 {
	
	variableDay vDay = new variableDay(1);
	
	static Hashtable< String , Integer > hash = new Hashtable< String , Integer >();
	static Hashtable< String , Float > probhash = new Hashtable<String , Float >();
	
	public void Read()
	{
		
		try {
			
			Workbook w = Workbook.getWorkbook(new File("capstone.xlt"));
			Sheet sh = w.getSheet(0);
			
			String word;
			
			hash.put("GG",0);
			hash.put("GY",0);
			hash.put("GK",0);
			hash.put("YG",0);
			hash.put("YY",0);
			hash.put("YK",0);
			hash.put("KG",0);
			hash.put("KY",0);
			hash.put("KK",0);
			
			
			for(int i=3;i<vDay.getNumberOfData();i++)
			{
				
				word = sh.getCell(3,i).getContents().toString()+sh.getCell(3,i+1).getContents().toString();

				hash.put(word,hash.get(word)+1);

			}
			
				probhash.put("GG",((float) hash.get("GG") / (hash.get("GG")+hash.get("GY")+hash.get("GK")) ));
				probhash.put("GY",((float) hash.get("GY") / (hash.get("GG")+hash.get("GY")+hash.get("GK")) ));
				probhash.put("GK",((float) hash.get("GK") / (hash.get("GG")+hash.get("GY")+hash.get("GK")) ));
				probhash.put("YG",((float) hash.get("YG") / (hash.get("YG")+hash.get("YY")+hash.get("YK")) ));
				probhash.put("YY",((float) hash.get("YY") / (hash.get("YG")+hash.get("YY")+hash.get("YK")) ));
				probhash.put("YK",((float) hash.get("YK") / (hash.get("YG")+hash.get("YY")+hash.get("YK")) ));
				probhash.put("KG",((float) hash.get("KG") / (hash.get("KG")+hash.get("KY")+hash.get("KK")) ));
				probhash.put("KY",((float) hash.get("KY") / (hash.get("KG")+hash.get("KY")+hash.get("KK")) ));
				probhash.put("KK",((float) hash.get("KK") / (hash.get("KG")+hash.get("KY")+hash.get("KK")) ));
			
			
				Weather_GUI.txt.setText(	"GG is :" + probhash.get("GG") + "\n" +
									"GY is :" + probhash.get("GY") + "\n" +
									"GK is :" +	probhash.get("GK") + "\n" +
									"YG is :" + probhash.get("YG") + "\n" +
									"YY is :" + probhash.get("YY") + "\n" +
									"YK is :" + probhash.get("YK") + "\n" +
									"KG is :" + probhash.get("KG") + "\n" +
									"KY is :" + probhash.get("KY") + "\n" +
									"KK is :" + probhash.get("KK") + "\n" +
									"-------------\n"+
									"G:Güneþli Y:Yaðmurlu K:Karlý \n "
								
					);
			
		} 
		catch (BiffException | IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	public Excel2() throws BiffException, IOException
	{
		
		Read();
		new Test2();
		
	}
}

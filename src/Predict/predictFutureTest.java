package Predict;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import Utilities.Functions;
import Utilities.Weather_GUI;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class predictFutureTest {
	
	Hashtable<String, Integer> pSquareHashtable = new Hashtable<>();
	
	public predictFutureTest() throws BiffException, IOException {
		
		int tr=0;
		int fl=0;
		
		Workbook w1 = Workbook.getWorkbook(new File("capstone.xlt"));
		Sheet sh1 = w1.getSheet(0);
		
		for(int i=1461;i<1820;i++){
			String wrd;
			wrd = sh1.getCell(3,i).getContents().toString();
		
			if((wrd+sh1.getCell(3,i+4).getContents().toString()).equals(Functions.findMax(wrd))){
				tr++;
			}
			else{
				fl++;
			}
		}
		
		Weather_GUI.txt.append("true:"+tr+"\nfalse:"+fl+"\n");
		Weather_GUI.txt.append(((double) tr/(tr+fl))*100+" %"+"\n");
		
	}
}

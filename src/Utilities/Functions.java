package Utilities;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableWorkbook;
import Predict.predictFuture;


public class Functions {

	public static Hashtable<String,Float> getSquareOfMatrixHashtable (Hashtable<String, Float> pHashtable){
		
		Hashtable<String, Float> pSquareHashtable = new Hashtable<>();
		
		pSquareHashtable.put("GG" , pHashtable.get("GG")*pHashtable.get("GG")+pHashtable.get("GY")*pHashtable.get("YG")+pHashtable.get("GK")*pHashtable.get("KG"));
		pSquareHashtable.put("GY" , pHashtable.get("GG")*pHashtable.get("GY")+pHashtable.get("GY")*pHashtable.get("YY")+pHashtable.get("GK")*pHashtable.get("KY"));
		pSquareHashtable.put("GK" , pHashtable.get("GG")*pHashtable.get("GK")+pHashtable.get("GY")*pHashtable.get("YK")+pHashtable.get("GK")*pHashtable.get("KK"));
		pSquareHashtable.put("YG" , pHashtable.get("GG")*pHashtable.get("YG")+pHashtable.get("YY")*pHashtable.get("YG")+pHashtable.get("YK")*pHashtable.get("KG"));
		pSquareHashtable.put("YY" , pHashtable.get("YG")*pHashtable.get("GY")+pHashtable.get("YY")*pHashtable.get("YY")+pHashtable.get("YK")*pHashtable.get("KY"));
		pSquareHashtable.put("YK" , pHashtable.get("YG")*pHashtable.get("GK")+pHashtable.get("YY")*pHashtable.get("YK")+pHashtable.get("YK")*pHashtable.get("KK"));
		pSquareHashtable.put("KG" , pHashtable.get("KG")*pHashtable.get("GG")+pHashtable.get("KY")*pHashtable.get("YG")+pHashtable.get("KK")*pHashtable.get("KG"));
		pSquareHashtable.put("KY" , pHashtable.get("KG")*pHashtable.get("GY")+pHashtable.get("KY")*pHashtable.get("YY")+pHashtable.get("KK")*pHashtable.get("KY"));
		pSquareHashtable.put("KK" , pHashtable.get("KG")*pHashtable.get("GK")+pHashtable.get("KY")*pHashtable.get("YK")+pHashtable.get("KK")*pHashtable.get("KK"));
		
		return pSquareHashtable;
		
	}
	
	public static Sheet readExcel(String filename) throws BiffException, IOException{
			Workbook workbook = Workbook.getWorkbook(new File(filename));
			Sheet sheet = workbook.getSheet(0);
				return sheet;
		}
	
	public static Sheet writeExcel(String filename , Sheet sheet , String word) throws IOException{
		
		WritableWorkbook workbook = Workbook.createWorkbook(new File(filename));
		Sheet sheet1 = workbook.createSheet("sh", 0);
			return sheet1;
		
	}

	public static String findMax(String wrrd){
		float number1=predictFuture.probhash.get(wrrd+"G");
		float number2=predictFuture.probhash.get(wrrd+"Y");
		float number3=predictFuture.probhash.get(wrrd+"K");
		
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
	
	public static BufferedWriter writeWord(String file) throws IOException{
		
		File txtFile = new File(file);
		
		if (!txtFile.exists()) {
			//System.out.println("as");
			txtFile.createNewFile();
			//System.out.println("da");
			
		}
		
		FileWriter fw = new FileWriter(txtFile.getAbsoluteFile());
		BufferedWriter bf = new BufferedWriter(fw);
		
		return bf;
		
	
	}
	
}

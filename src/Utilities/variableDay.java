package Utilities;

public class variableDay {

	private int day;
	
	public int getDay(){
		return this.day;
	}
	
	public void setDay(int day){
		this.day = day;
	}
	
	private int numberOfData;
	
	public int getNumberOfData() {
		return numberOfData;
	}

	public void setNumberOfData(int numberOfData) {
		this.numberOfData = numberOfData;
	}
	
	private int numberOfTest;
	
	public int getNumberOfTest() {
		return numberOfTest;
	}

	public void setNumberOfTest(int numberOfTest) {
		this.numberOfTest = numberOfTest;
	}
	
	
	public void assignVariable(){
		
		switch (day) {
		case 1:
			numberOfData=1460;
			numberOfTest=1825;
			break;

		default:
			break;
		}
	}
	
	public variableDay(int day){
		this.day=day;
		assignVariable();
	}

	

	
}

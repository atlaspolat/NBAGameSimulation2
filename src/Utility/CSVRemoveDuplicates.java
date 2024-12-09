package Utility;

import java.util.ArrayList;

/**
 * 
 * this class removed the duplicate entries and resized the file to our needs
 * 
 */
public class CSVRemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		removeDuplicates();

	}
	
	
	public static void getNecessaryInfo() {

		ArrayList<String[]> arr = new ArrayList<String[]>();
		ArrayList<String[]> newArr = new ArrayList<String[]>();
		
		CSVReader.readCSV(arr, "data\\2022-2023NBA PlayerStats.csv", ";");
		
		
		
		
		
		
		for (String[] data : arr) {
			
			String[] newData = {data[0], data[1], data[2], data[3], data[4], data[29], data[23], data[24], data[26], data[25]};
			
			newArr.add(newData);
			
		}
		
		
	
		
		CSVWriter.writeCSV(newArr, "data\\2022-2023NBA PlayerStats2.csv", ";");
	}
	
	public static void removeDuplicates() {
		
		
		ArrayList<String[]> arr = new ArrayList<String[]>();
		ArrayList<String[]> newArr = new ArrayList<String[]>();
		
		CSVReader.readCSV(arr, "data\\2022-2023NBA PlayerStats2.csv", ";");
		
		
		
		
		
		ArrayList<String[]> copies = new ArrayList<>();
		
		int index = 2;
		
		for (int i = 1; i < arr.size(); i++) {
			String[] dataLine = arr.get(i);
			
			int playerIndex = Integer.parseInt(dataLine[0]);
			
			System.out.println("index:" + Integer.toString(index) + "player index:" + Integer.toString(playerIndex));
			
			if(index > playerIndex) {
				
				copies.add(dataLine);
			}else if(index == playerIndex) {
				
				if(copies.size() > 1) {
					
					newArr.add(sumUpStats(copies));
					
				}else {
					
					newArr.add(copies.get(0));
				}
				
				copies = new ArrayList<String[]>();
				copies.add(dataLine);
				index++;
			}
			
		}
		
		newArr.add(copies.get(0));
		
		
		
	
		
		CSVWriter.writeCSV(newArr, "data\\2022-2023NBA PlayerStats3.csv", ";");
		
	}
	
	
	
	
	public static String[] sumUpStats(ArrayList<String[]> duplicates) {
		
		String[] avarage = new String[10];
		
		avarage[0] = duplicates.get(0)[0];
		avarage[1] = duplicates.get(0)[1];
		avarage[2] = duplicates.get(0)[2];
		avarage[3] = duplicates.get(0)[3];
		avarage[4] = duplicates.get(0)[4];
		
		
		
		for (int i = 5; i < 10; i++) {
			
			double sumPoints = 0;
			
			
			for (String[] data : duplicates) {
				
				sumPoints += Double.valueOf(data[i]);
				
			}
			
			
			
			avarage[i] = String.format("%.1f", sumPoints / duplicates.size());
		}
		
		
		
		
		
		
		
		
		
		return avarage;
	}
	

}

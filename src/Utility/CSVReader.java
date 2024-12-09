package Utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CSVReader {
	
	
	
	
	/**
	 * Keeping the userDir in a constant variable
	 * 
	 */
	public static final String userDir = System.getProperty("user.dir");

	/**
	 * 
	 * @param relativePath the path to use the project folder
	 * @param separator the separator used in the CSV file
	 */
	
	public static void readCSV(ArrayList<String[]> arr, String relativePath, String separatorRegex) {
		
		
		String file = userDir + "\\" + relativePath;
		 
		CharSequence charSequence = "sep=";
		
		
		try (BufferedReader buffReader = new BufferedReader(new FileReader(file))) {
			
			String line = "";
			
			while((line = buffReader.readLine()) != null) {
				
				if(line.contains(charSequence)) {
					continue;
				}
				
				String[] row = line.split(separatorRegex);
				
				arr.add(row);
				
			
			}
			
			
			
			buffReader.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
	}

}

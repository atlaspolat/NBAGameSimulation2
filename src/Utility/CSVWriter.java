package Utility;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CSVWriter {
	
	/**
	 * Keeping the userDir in a constant variable
	 * 
	 */
	public static final String userDir = System.getProperty("user.dir");
	
	
	
	public static void appendCSV(ArrayList<String[]> arr, String relativePath, String separatorRegex) {
		
		
		Iterator<String[]> iterator = arr.iterator();
		
		


		try(FileWriter fw = new FileWriter(userDir + "\\" + relativePath, true);
		BufferedWriter writer = new BufferedWriter(fw);) {
			
			
			while (iterator.hasNext()) { // loop until end-of-file indicator	
		           
	        	 String[] lineArr = iterator.next();
	        	 
	        	 //System.out.println(lineArr);
	        	 
	        	 /*for (String data : lineArr) {

	        		 writer.write(String.format("%s%s", data, separatorRegex));
					
				}*/
	        	 
	        	for (int i = 0; i < lineArr.length; i++) {
					String data = lineArr[i];
					
					
					if(i != lineArr.length - 1) {
						writer.write(String.format("%s%s", data, separatorRegex));
					}else {
						writer.write(String.format("%s", data));
					}
					
				}
	        	 
	        	 writer.write("\n");

	         }
			

		 
		}catch(Exception e) {
			e.printStackTrace();
	         System.exit(1); // terminate the program
			
		}
		
		
	}
	
	
	public static void appendCSV(String text, String relativePath, String separatorRegex) {
		

		
		
		ArrayList<String[]> arr = new ArrayList<>(); 
		
		String lines[] = text.split("\n");
		
		for (int i = 0; i < lines.length; i++) {
			
			arr.add(lines[i].split(separatorRegex));
			
		}
		
		CSVWriter.appendCSV(arr, relativePath, separatorRegex);
		
		
		
	}
	
	
	public static void writeCSV(ArrayList<String[]> arr, String relativePath, String separatorRegex) {
		
		Iterator<String[]> iterator = arr.iterator();
		
		
		 try (Formatter output = new Formatter(userDir + "\\" + relativePath)) {
			 
			 
	    	  
	         while (iterator.hasNext()) { // loop until end-of-file indicator	
	           
	        	 String[] lineArr = iterator.next();
	        	 
	        	 //System.out.println(lineArr);
	        	 
	        	/* for (String data : lineArr) {
	        		 
	        		 output.format("%s%s", data, separatorRegex);
					
				}*/
	        	 
	        	 for (int i = 0; i < lineArr.length; i++) {
					String data = lineArr[i];
					
					if(i != lineArr.length - 1) {
						output.format("%s%s", data, separatorRegex);
					}else {
						output.format("%s", data);
					}
					
				}
	        	 
	        	 output.format("%n");

	         }
	         
	         
	         output.close();
	      }
	      catch (SecurityException | FileNotFoundException | 
	         FormatterClosedException e) {
	         e.printStackTrace();
	         System.exit(1); // terminate the program
	      }
		
		
		
	}
	
	
	public static void writeCSV(String text, String relativePath, String separatorRegex) {
		
		ArrayList<String[]> arr = new ArrayList<>(); 
		
		String lines[] = text.split("\n");
		
		for (int i = 0; i < lines.length; i++) {
			
			arr.add(lines[i].split(separatorRegex));
			
		}
		
		CSVWriter.writeCSV(arr, relativePath, separatorRegex);
		
	}

}

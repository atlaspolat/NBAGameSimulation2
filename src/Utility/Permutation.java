package Utility;

import java.util.HashSet;
import java.util.Random;



/**
 * 
 * Give us a set of numbers among a wide range
 * 
 */
public class Permutation {
	
	
	static Random rd;
	
	/**
	 * 
	 * 
	 * @param numT
	 * @param numC
	 * @return
	 */

	public static HashSet<Integer> permutate(int numT, int numC) {
		
		rd = new Random();
		
		HashSet<Integer> result = new HashSet<Integer>();
		
		while(result.size() < numC) {
			
			result.add(rd.nextInt(0, numT));
			
		}
		
		
		return result;
	}

}

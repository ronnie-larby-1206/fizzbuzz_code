/**
 * 
 */
package com.mac.fizzbuzz.converter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mac.fizzbuzz.exception.FizzBuzzParametersException;

/**
 * @author Ronnie Larby
 *
 */
public abstract class ConvertNumber {
	
	public static final String SPACE_DELIMITER = " ";
	
	private Map<String,Integer> stats;
	
	public abstract String convert(List<Integer> divisors, Integer fromNumber, Integer toNumber) throws FizzBuzzParametersException;	
	
	public Map<String, Integer> getStats() {
		if (stats == null) {
			stats = new HashMap<String,Integer>();
		}
		
		return stats;
	}

}

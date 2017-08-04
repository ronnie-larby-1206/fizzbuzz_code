/**
 * 
 */
package com.mac.fizzbuzz.main;

import java.util.ArrayList;
import java.util.List;

import com.mac.fizzbuzz.converter.ConvertNumber;
import com.mac.fizzbuzz.converter.ConvertNumberLuckyImpl;
import com.mac.fizzbuzz.exception.FizzBuzzParametersException;

/**
 * @author Ronnie Larby
 *
 */
public class FizzBuzzMain {

	/**
	 * @param args
	 * @throws FizzBuzzParametersException 
	 */
	public static void main(String[] args) throws FizzBuzzParametersException {
		
		FizzBuzzMain fb = new FizzBuzzMain();
		
		fb.execute();

	}

	/**
	 * Executes the conversion
	 * 
	 * @throws FizzBuzzParametersException
	 */
	private void execute() throws FizzBuzzParametersException  {

		ConvertNumber convertNumber = new ConvertNumberLuckyImpl();
		
		List<Integer> divisors = new ArrayList<Integer>();
		divisors.add(3);
		divisors.add(5);
		Integer fromNumber = 1;
		Integer toNumber = 20;
		System.out.println(convertNumber.convert(divisors, fromNumber, toNumber));
		
		for (String desc:convertNumber.getStats().keySet()) {
			System.out.println(desc + ": " + convertNumber.getStats().get(desc));
		}
		
		
	}

}

/**
 * 
 */
package com.mac.fizzbuzz.converter;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.text.StrTokenizer;

import com.mac.fizzbuzz.enumeration.NumberToString;
import com.mac.fizzbuzz.exception.FizzBuzzParametersException;
import com.mac.fizzbuzz.validation.FizzBuzzParametersValidator;

/**
 * @author Ronnie Larby
 * 
 * Converts numbers to strings
 *
 */
public class ConvertNumberImpl extends ConvertNumber {

	/*
	 * (non-Javadoc)
	 * @see com.mac.fizzbuzz.converter.ConvertNumber#convert(java.util.List, java.lang.Integer, java.lang.Integer)
	 */
	/**
	 * Takes a range of numbers and converts to a String of contiguous numbers(1 to 20). It then converts any number in the string which is exactly divisible, by the given divisors (3 and 5), into String equivalents i.e.
	 * if it is divisible by three that number is converted to 'fizz' and if it is divisible by 5 it is converted to 'buzz.. If it is divisible by both it is converted to 'fizzbuzz'.
	 * Will produce a String of 1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz
	 * 
	 */
	public String convert(List<Integer> divisors, Integer fromNumber , Integer toNumber) throws FizzBuzzParametersException {

		// validate the parameters
		FizzBuzzParametersValidator.validate(divisors, fromNumber, toNumber);

		StringBuilder sb = new StringBuilder();

		// create a space delimited string of all numbers within the range
		for (int i=fromNumber;i<=toNumber;i++) {
			sb.append(i);
			// don't add space to end of string
			if (i < toNumber) {
				sb.append(SPACE_DELIMITER);
			}
		}

		// used to create an iterable list of the individual numbers
		StrTokenizer st = new StrTokenizer(sb.toString(), SPACE_DELIMITER);
		// do not add empty tokens
		st.setIgnoreEmptyTokens(true);

		// reset the StringBuilder
		sb.setLength(0);

		// loop through the list of numbers and convert if appropriate, Append result to strinbuilder.
		Iterator<String> iterator = st.getTokenList().iterator();
		while(iterator.hasNext()){
			boolean numberConverted = false;
			Integer currentNumber = Integer.parseInt(iterator.next());
			for (Integer divisor : divisors) {
				if (currentNumber % divisor == 0){
					sb.append(NumberToString.valueOf(divisor));
					numberConverted = true;
				}
			}
			// is not divisable so output original number
			if (!numberConverted) {
				sb.append(currentNumber);
			}
			// don't add string at end of string
			if(iterator.hasNext()){
				sb.append(SPACE_DELIMITER);
			}
		}

		return sb.toString();

	}

}

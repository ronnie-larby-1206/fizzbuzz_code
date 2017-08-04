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
public class ConvertNumberLuckyImpl extends ConvertNumber {

	/*
	 * (non-Javadoc)
	 * @see com.mac.fizzbuzz.converter.ConvertNumber#convert(java.util.List, java.lang.Integer, java.lang.Integer)
	 */
	/**
	 * Takes a range of numbers and converts to a String of contiguous numbers(1 to 20). It then converts any number in the string which is exactly divisible, by the given divisors (3 and 5), into String equivalents i.e.
	 * if it is divisible by three that number is converted to 'fizz' and if it is divisible by 5 it is converted to 'buzz.. If it is divisible by both it is converted to 'fizzbuzz'.
	 * If any number contains the digit 3 it is converted to 'lucky' and this overrides the previous rules. Also produce stats of each string.
	 * Will produce a String of 1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz
	 * fizz: 4
	 * buzz: 3
	 * fizzbuzz: 1
	 * luck: 2
	 * number: 10

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
			String currentToken = iterator.next();
			Integer currentNumber = Integer.parseInt(currentToken);
			// does number contain the digit 3
			if (currentToken.indexOf("3") >= 0) {
				sb.append(NumberToString.CONTAINS_THREE.getDesc());
				addToStats(NumberToString.CONTAINS_THREE.getDesc());
				numberConverted = true;
			} else {
				String newValue = "";
				for (Integer divisor : divisors) {
					if (currentNumber % divisor == 0){
						newValue = newValue + NumberToString.valueOf(divisor);
						numberConverted = true;
					}
				}
				if (newValue != "") {
					sb.append(newValue);
					addToStats(newValue);
					
				}
			}
			// is not divisable and doesn't contain the digit 3	 so output original number
			if (!numberConverted) {
				sb.append(currentNumber);
				addToStats(NumberToString.NUMBER.getDesc());
			}
			// don't add string at end of string
			if(iterator.hasNext()){
				sb.append(SPACE_DELIMITER);
			}
		}

		return sb.toString();

	}
	
	private void addToStats(String key) {
		
		if (!this.getStats().containsKey(key)) {
			this.getStats().put(key,1);
		} else {
			Integer currentValue = this.getStats().get(key) + 1;
			this.getStats().put(key, currentValue);
		}
	}

}

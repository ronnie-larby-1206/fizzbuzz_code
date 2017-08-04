/**
 * 
 */
package com.mac.fizzbuzz.validation;

import java.util.List;

import com.mac.fizzbuzz.exception.FizzBuzzParametersException;

/**
 * @author Ronnie Larby
 *
 */
public class FizzBuzzParametersValidator {
	
	public static final String DIVISORS_EMPTY = "No divisors supplied";
	public static final String TO_NUMBER_ZERO = "end of range can not be zero";
	public static final String TO_NUMBER_NULL = "end of range must be supplied";
	public static final String FROM_NUMBER_ZERO = "start of range can not be zero";
	public static final String FROM_NUMBER_NULL = "start of range must be supplied";
	public static final String TO_GREATER_FROM = "end of range must be greater than or equal to start of range";
	
	public static void validate(List<Integer> divisors, Integer fromNumber, Integer toNumber) throws FizzBuzzParametersException {
		
		if (divisors == null || divisors.isEmpty()) {
			throw new FizzBuzzParametersException(DIVISORS_EMPTY);
		}
		
		if (toNumber == null) {
			throw new FizzBuzzParametersException(TO_NUMBER_NULL);
		}
		
		if (toNumber == 0) {
			throw new FizzBuzzParametersException(TO_NUMBER_ZERO);
		}
		
		if (fromNumber == null) {
			throw new FizzBuzzParametersException(FROM_NUMBER_NULL);
		}
		
		if (fromNumber == 0) {
			throw new FizzBuzzParametersException(FROM_NUMBER_ZERO);
		}
		
		if (fromNumber > toNumber) {
			throw new FizzBuzzParametersException(TO_GREATER_FROM);
		}
				
	}
}

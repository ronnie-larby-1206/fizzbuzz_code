package com.mac.fizzbuzz.validator;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.mac.fizzbuzz.exception.FizzBuzzParametersException;
import com.mac.fizzbuzz.validation.FizzBuzzParametersValidator;

/**
 * Test cases for the FizzBuzzParametersValidator class.
 * 
 * @author Ronnie Larby
 *
 */
public class FizzBuzzParametersValidatorTest {
	
	private Integer fromNumber;
	private Integer toNumber;
	private List<Integer> divisors;
	
	@Before
    public final void setUp() {
        fromNumber = 1;
        toNumber = 20;
        divisors = new ArrayList<Integer>();
        divisors.add(3);
        divisors.add(5);
    }

	@Test
    public void testDivisorParamNullException() {
		
		try {
            FizzBuzzParametersValidator.validate(null, fromNumber, toNumber);
            
            fail("This should have thrown an exception");

        } catch (FizzBuzzParametersException e) {
        	assertEquals(e.getMessage(),FizzBuzzParametersValidator.DIVISORS_EMPTY);
        }
		
		
	}
	
	@Test
    public void testDivisorParamEmptyException() {
		
		try {
            FizzBuzzParametersValidator.validate(new ArrayList<Integer>(), fromNumber, toNumber);
            
            fail("This should have thrown an exception");

        } catch (FizzBuzzParametersException e) {
        	assertEquals(e.getMessage(),FizzBuzzParametersValidator.DIVISORS_EMPTY);
        }
		
		
	}
	
	@Test
    public void testFromNumberParamNullException() {
		
		try {
            FizzBuzzParametersValidator.validate(divisors, null, toNumber);
            
            fail("This should have thrown an exception");

        } catch (FizzBuzzParametersException e) {
        	assertEquals(e.getMessage(),FizzBuzzParametersValidator.FROM_NUMBER_NULL);
        }
		
		
	}
	
	@Test
    public void testFromNumberParamZeroException() {
		
		try {
            FizzBuzzParametersValidator.validate(divisors, 0, toNumber);
            
            fail("This should have thrown an exception");

        } catch (FizzBuzzParametersException e) {
        	assertEquals(e.getMessage(),FizzBuzzParametersValidator.FROM_NUMBER_ZERO);
        }
		
		
	}
	
	@Test
    public void testToNumberParamNullException() {
		
		try {
            FizzBuzzParametersValidator.validate(divisors, fromNumber, null);
            
            fail("This should have thrown an exception");

        } catch (FizzBuzzParametersException e) {
        	assertEquals(e.getMessage(),FizzBuzzParametersValidator.TO_NUMBER_NULL);
        }
		
		
	}
	
	@Test
    public void testToNumberParamZeroException() {
		
		try {
            FizzBuzzParametersValidator.validate(divisors, fromNumber, 0);
            
            fail("This should have thrown an exception");

        } catch (FizzBuzzParametersException e) {
        	assertEquals(e.getMessage(),FizzBuzzParametersValidator.TO_NUMBER_ZERO);
        }
		
		
	}
	
	@Test
    public void testToNumberParamGreaterThanFromNumberParamException() {
		
		try {
            FizzBuzzParametersValidator.validate(divisors, 21, toNumber);
            
            fail("This should have thrown an exception");

        } catch (FizzBuzzParametersException e) {
        	assertEquals(e.getMessage(),FizzBuzzParametersValidator.TO_GREATER_FROM);
        }
		
		
	}
	
	@Test
    public void testValidParams() {
		
		try {
            FizzBuzzParametersValidator.validate(divisors, fromNumber, toNumber);

        } catch (FizzBuzzParametersException e) {
        	fail("This should not have thrown an exception");
        }
		
		
	}

}

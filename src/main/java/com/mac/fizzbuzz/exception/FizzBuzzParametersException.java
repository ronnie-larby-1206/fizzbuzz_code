/**
 * 
 */
package com.mac.fizzbuzz.exception;

/**
 * @author Ronnie Larby
 * 
 * Custom exception
 *
 */
public class FizzBuzzParametersException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Constructor.
     */
    public FizzBuzzParametersException() {

    }

    /**
     * Constructor.
     * 
     * @param message
     *            the message
     */
    public FizzBuzzParametersException(final String message) {
        super(message);

    }

}

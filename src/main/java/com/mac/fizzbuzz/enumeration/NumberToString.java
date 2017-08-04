/**
 * 
 */
package com.mac.fizzbuzz.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ronnie Larby
 *
 */
public enum NumberToString {	

	DIVISIBLE_BY_THREE(3,"fizz"),
	DIVISIBLE_BY_FIVE(5,"buzz"),
	CONTAINS_THREE(999,"lucky"),
	NUMBER(000,"number"),
	DIVISIBLE_BY_THREE_AND_FIVE(35,"fizzbuzz");

	private Integer number;
	private String desc;
	
	private static Map<Integer, String> map = new HashMap<Integer, String>();
	
	static {
		for (NumberToString numberToString : NumberToString.values()) {
			map.put(numberToString.number, numberToString.desc);
		}
	}

	private NumberToString(Integer number, String desc) {
		this.number = number;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public static String valueOf(Integer number) {
		return map.get(number);
	}
}

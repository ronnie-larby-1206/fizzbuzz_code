package com.mac.fizzbuzz.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ronnie Larby
 *
 */
public class FizzBuzzResults {
	
	private String result;
	private Map<String,Integer> stats;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Map<String, Integer> getStats() {
		if (stats == null) {
			stats = new HashMap<String,Integer>();
		}
		
		return stats;
	}
	@Override
	public String toString() {
		return "FizzBuzzResults [result=" + result + ", stats=" + stats + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		result = prime * result + ((stats == null) ? 0 : stats.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FizzBuzzResults other = (FizzBuzzResults) obj;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		if (stats == null) {
			if (other.stats != null)
				return false;
		} else if (!stats.equals(other.stats))
			return false;
		return true;
	}
	
	

}

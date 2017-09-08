package com.nrg.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

public class CommonUtils {
	private static final BigDecimal ONE_BILLION = new BigDecimal(1000000000L);
	
	public static String toHexString(byte[] ba) {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < ba.length; i++) {
			str.append(String.format("%02X", ba[i]));
			str.append(" ");
		}
		return str.toString();
	}

	 public static int hex2Decimal(String s) {
	        String digits = "0123456789ABCDEF";
	        s = s.toUpperCase();
	        int val = 0;
	        for (int i = 0; i < s.length(); i++) {
	            char c = s.charAt(i);
	            int d = digits.indexOf(c);
	            val = 16*val + d;
	        }
	        return val;
	    }


	public static long hexaDecimalToDate(String hexData) {
		return new BigInteger(hexData, 16).divide(BigInteger.valueOf(1000000000)).longValue();
	}
	
	

	public static Timestamp toTimestamp(BigDecimal value) {

		long seconds = value.longValue();
		int nanoseconds = extractNanosecondDecimal(value, seconds);

		Timestamp ts = new Timestamp(seconds * 1000);
		ts.setNanos(nanoseconds);
		return ts;
	}

	public static int extractNanosecondDecimal(BigDecimal value, long integer) {
		return value.subtract(new BigDecimal(integer)).multiply(ONE_BILLION).intValue();
	}
	
}

package com.nrg.datacatcher.utils;

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
			val = 16 * val + d;
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
	
	public static double hexToLatLong(String s) {
	    return Integer.parseUnsignedInt(s, 16) / 1e7;
	}
		
	public static void main(String[] args) {
		System.out.println(hex2Decimal("000D55"));
	}

	/*public static String getLatitude(String hex) {
        int latStart=0;
        String str09 = hex.substring(latStart,latStart+8);
        System.out.println("latitude Hex::"+str09);
        Integer outDec = Integer.parseInt(str09, 16);
        double d = outDec / new Double(1000);
        System.out.println("Hex to float>>>" + d);
        double lat = d /`enter code here` 3600;
        return String.valueOf(lat);
    }

	public static String getLongitude(String hex) throws Exception {
		int lonStart = 8;
		String str09 = hex.substring(lonStart, lonStart + 8);
		System.out.println("Longitude Hex::" + str09);
		Integer outDec = Integer.parseInt(str09, 16);
		double d = outDec / new Double(1000);
		System.out.println("Hex to float>>>" + asHex);
		double lon = d / 3600;
		return String.valueOf(lon);
	}*/
}

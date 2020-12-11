package com.isaac.sisgreja.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Funcoes {

	private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");

	public static Date stringToDate(String s) throws ParseException {

		return format.parse(s);
	}
	
	public static Date stringToDate2(String s) throws ParseException {

		return format2.parse(s);
	}

	public static String dateToString(Date data) {

		return format.format(data);
	}
}

package br.edu.uniateneu.bolao.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringEscapeUtils;

@SuppressWarnings("deprecation")
public class StringUtil2 {

	@SuppressWarnings("unused")
	public static String decodificar(String texto) {
		return  StringEscapeUtils.unescapeJava(texto);
	}
	@SuppressWarnings("unused")
	public static Date converteStringToDate(String dateStr) {
		Date data = null;
		try {
			data = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateStr.replace('T', ' '));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return data;
	}
	public static void main(String[] args) {

	}

}


package br.edu.uniateneu.bolao.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringEscapeUtils;

@SuppressWarnings("deprecation")
public class StringUtil {
	 final static Charset cp1252 = Charset.forName("windows-1252");
	 final static Charset utf8 = Charset.forName("UTF-8");


	@SuppressWarnings("unused")
	public static String decodificar(String texto) {
		return  StringEscapeUtils.unescapeJava(texto);
	}
	
	public static String decodificarUTF8(String input) throws UnsupportedEncodingException  {
		
		 // lets convert it to bytes in windows-1252:
		 // this gives you 2 bytes: c3 bc
		 // "Ã" ==> c3
		 // "¼" ==> bc
		 byte[] windows1252Bytes = input.getBytes(cp1252);

		 // but in utf-8, c3 bc is "ü"
		 String fixed = new String(windows1252Bytes, utf8);
		 System.out.println(new String(fixed.getBytes(), "Windows-1252"));
		 return fixed;
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


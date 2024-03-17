package mx.com.hsbc.util;


import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeAndDateUtils {
	public static java.sql.Date getDateFromString(String fecha) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date sqlDate = null;
		try {
			Date parsed = format.parse(fecha);
			sqlDate = new java.sql.Date(parsed.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sqlDate;
	} 
	
	public static Time getTimeFromString(String hora) {
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		Time t = null;
		try {
			long ms = sdf.parse(hora).getTime();
			 t = new Time(ms);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return t;
	}
}

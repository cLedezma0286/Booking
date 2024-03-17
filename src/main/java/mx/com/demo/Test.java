package mx.com.demo;

import java.sql.Date;
import java.sql.Time;

import mx.com.hsbc.util.TimeAndDateUtils;

public class Test {
	public static void main(String[] args) {
		String fecha = "24/02/2024";
		Date fechaDate = TimeAndDateUtils.getDateFromString(fecha);
		System.out.println("fecha: " + fechaDate);
		String hora = "10:00:00";
		Time horaT = TimeAndDateUtils.getTimeFromString(hora);
		System.out.println("Hora: " + horaT);
	}
}

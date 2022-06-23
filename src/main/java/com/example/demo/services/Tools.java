package com.example.demo.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.demo.services.exception.ObjectNotFoundException;

public class Tools {
	
public static Date StringToDate(String data) {
	try {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.parse(data);
	} catch (ParseException e) {
		throw new ObjectNotFoundException("Data inválida " + data);
	}
}
}

package com.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {

	public static void main(String[] args) {
		
		Pattern p=Pattern.compile("^[6-9]\\d{9}$");
		Matcher m=p.matcher("6566778890");
		
		System.out.println(m.matches());
		
	}
}

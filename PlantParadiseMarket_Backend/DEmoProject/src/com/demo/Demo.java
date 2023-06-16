package com.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {

	public static void main(String[] args) {
		
		Pattern p=Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])[a-zA-Z\\d@#$%^&+=]{6,15}$");
		Matcher m=p.matcher("Abhi@12");
		
		System.out.println(m.matches());
		
	}
}

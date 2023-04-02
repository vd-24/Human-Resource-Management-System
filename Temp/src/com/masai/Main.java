package com.masai;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {

	public static void main(String[] args) {
		  LocalDate one = LocalDate.parse("2023-03-30");
		    LocalDate two = LocalDate.parse("2023-03-30");
		    
		    System.out.println(ChronoUnit.DAYS.between(one, two));
	}

}

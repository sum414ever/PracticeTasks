package com.company.sprint13DateTimeIO;

import java.time.LocalDate;

public class Task3 {

  public static void main(String[] args) {

    System.out.println(isLeapYear(2020));
  }
  public static boolean isLeapYear(int year) {
    LocalDate localDate = LocalDate.of(year,12,31);
    return localDate.getDayOfYear()==366;
  }
}

//  Write a method to check if a year is a leap year or not, using for this the LocalDate class.
//
//    If a year is leap then method should return true, otherwise - false.
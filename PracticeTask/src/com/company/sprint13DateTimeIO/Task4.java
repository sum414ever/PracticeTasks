package com.company.sprint13DateTimeIO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task4 {

  public static void main(String[] args) {
    System.out.println(getDateAfterToday(3, 18, 27));
  }

  public static String getDateAfterToday(int years, int months, int days) {

    LocalDate now = LocalDate.now();
    now = now.plusYears(years);
    now = now.plusMonths(months);
    now = now.plusDays(days);

    int year = now.getYear();
    int month = now.getMonthValue();
    int day = now.getDayOfMonth();

    return DateTimeFormatter.ISO_LOCAL_DATE
        .format(LocalDate.of(year, month, day));
  }
}

//  Write a method to get the date n-years m-months and k-days after today using new DateTime API.
//
//    Return the obtained date in the format ISO_LOCAL_DATE.
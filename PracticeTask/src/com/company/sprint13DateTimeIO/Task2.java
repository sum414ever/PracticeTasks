package com.company.sprint13DateTimeIO;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Task2 {

  public static void main(String[] args) {

    System.out.println(lastDayOfMonth(Calendar.SEPTEMBER, 2015));
  }

  public static String lastDayOfMonth(int month, int year) {

    if (month < 0 || month > 11) {
      return "Wrong Month";
    } else {

      Calendar calendar = new GregorianCalendar();
      calendar.set(Calendar.YEAR, year);
      calendar.set(Calendar.MONTH, month);

      int actualMaximumDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

      calendar.set(Calendar.DAY_OF_MONTH, actualMaximumDay);

      int dayNumber = calendar.get(Calendar.DAY_OF_WEEK);


      return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, java.util.Locale.US);
    }
  }
}

//  Write a method to get the name of last day of the given month in given year.
//
//    Use GregorianCalendar class to solve this exercise.
//
//    The name of day must corresponds next format: Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday.
//
//    If month isn't correct then name is "Wrong Month".
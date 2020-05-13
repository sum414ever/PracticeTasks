package com.company.sprint13DateTimeIO;

import java.util.Calendar;
import java.util.Date;


public class Task1 {

  public static void main(String[] args) {

  }

  public static Calendar convertDateToCalendar(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar;
  }
}
//  Write a method to convert date and time, represented via Date object to object of Calendar type.


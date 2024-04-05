package com.personal.testApp.service.helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateValidation {

  public static boolean isDateBetween(final String date, final String startDate, final String endDate) {
    var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
    var applicationDate = LocalDateTime.parse(date, formatter);
    var start = LocalDateTime.parse(startDate, formatter);
    var end = LocalDateTime.parse(endDate, formatter);

    return applicationDate.isEqual(start) || applicationDate.isEqual(end) || (applicationDate.isAfter(start) && applicationDate.isBefore(end));
  }

}

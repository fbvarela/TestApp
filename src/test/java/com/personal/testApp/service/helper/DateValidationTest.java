package com.personal.testApp.service.helper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class DateValidationTest {

  @InjectMocks
  public DateValidation dateValidation;

  @Test
  @DisplayName("Date equal to start date and before end date")
  void whenDateIsEqualToStartDateAndBeforeThanEndDateReturnTrue() {
    String date = "2023-04-05-12.00.00";
    String startDate = "2023-04-05-12.00.00";
    String endDate = "2023-04-10-12.00.00";

    boolean result = DateValidation.isDateBetween(date, startDate, endDate);

    Assertions.assertTrue(result);
  }

  @Test
  @DisplayName("Date equal to end date and before end date")
  void whenDateIsEqualToEndDateAndAndBeforeThanStartDateThenReturnTrue() {
    String date = "2023-04-10-12.00.00";
    String startDate = "2023-04-05-12.00.00";
    String endDate = "2023-04-10-12.00.00";

    boolean result = DateValidation.isDateBetween(date, startDate, endDate);

    Assertions.assertTrue(result);
  }

  @Test
  @DisplayName("Date equal to end date and after start date")
  void whenDateIsBeforeStartDateThenReturnFalse() {
    String date = "2023-04-01-12.00.00";
    String startDate = "2023-04-05-12.00.00";
    String endDate = "2023-04-10-12.00.00";

    boolean result = DateValidation.isDateBetween(date, startDate, endDate);

    Assertions.assertFalse(result);
  }

  @Test
  @DisplayName("Date equal to end date and after end date")
  void whenDateIsAfterEndDateThenReturnFalse() {
    String date = "2023-04-12-12.00.00";
    String startDate = "2023-04-05-12.00.00";
    String endDate = "2023-04-10-12.00.00";

    boolean result = DateValidation.isDateBetween(date, startDate, endDate);

    Assertions.assertFalse(result);
  }
}
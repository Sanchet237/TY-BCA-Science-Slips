/*Q2. Define a class MyDate (day, month, year) with methods to accept and display MyDate object. 
Accept date as dd, mm, yyyy. Throw user defined exception “InvalidDateException” ifthe date 
is invalid. Examples of invalid dates : 12 15 2015, 31 6 1990, 29 2 2001 
[20 Marks]  */

import java.util.Scanner;
class InvalidDateException extends Exception {
    public InvalidDateException(String message) {
        super(message);
    }
}
class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) throws InvalidDateException {
        if (!isValidDate(day, month, year)) {
            throw new InvalidDateException("Invalid date: " + day + "/" + month + "/" + year);
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    private boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12 || day < 1) return false;

        int[] daysInMonth = {31, (isLeapYear(year) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return day <= daysInMonth[month - 1];
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public void display() {
        System.out.printf("Date: %02d/%02d/%04d%n", day, month, year);
    }
}
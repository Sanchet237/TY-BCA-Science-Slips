/*Q1. Create a package named “Series” having a class to print series of Square of numbers. Write a 
program to generate “n” terms series. [10 Marks]*/

import Series.SquareSeries;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();

        SquareSeries series = new SquareSeries();
        series.printSeries(n);
    }
}



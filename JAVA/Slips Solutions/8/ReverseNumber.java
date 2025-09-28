// Q1. Write a program to reverse a number. Accept number using command line argument. [10 Marks] 

public class ReverseNumber {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a number as a command line argument.");
            return;
        }

        try {
            int number = Integer.parseInt(args[0]);
            int reversed = 0;
            int temp = number;

            while (temp != 0) {
                int digit = temp % 10;
                reversed = reversed * 10 + digit;
                temp /= 10;
            }

            System.out.println("Original number: " + number);
            System.out.println("Reversed number: " + reversed);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid integer.");
        }
    }
}

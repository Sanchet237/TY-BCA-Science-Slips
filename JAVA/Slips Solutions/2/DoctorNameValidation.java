/* Q2. Write a program to accept Doctor Name from the user and check whether it is valid or not.
(It should not contain digits and special symbols) If it is not valid then throw user defined Exception - Name is Invalid 
-- otherwise display the name. [20 Marks] */

import java.util.*;

class InvalidNameException extends Exception {
    InvalidNameException(String msg) {
        super(msg);
    }
}

public class DoctorNameValidation {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter Doctor Name: ");
            String name = sc.nextLine();

            try {
                if (!name.matches("(Dr\\.? )?[a-zA-Z ]+")) {
                    throw new InvalidNameException("Name is Invalid");
                }
                System.out.println("Valid Doctor Name: " + name);
            } catch (InvalidNameException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}

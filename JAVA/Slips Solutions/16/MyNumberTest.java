/*Q1. Define a class MyNumber having one private integer data member. Write a parameterized 
constructor to initialize to a value. Write isEven() to check given number is even or not. Use 
command line argument to pass a value to the object. [10 Marks] */

class MyNumber {
    private int number;

    public MyNumber(int number) {
        this.number = number;
    }

    public boolean isEven() {
        return number % 2 == 0;
    }
}

public class MyNumberTest {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a number as a command-line argument.");
            return;
        }

        int num = Integer.parseInt(args[0]);
        MyNumber myNum = new MyNumber(num);

        if (myNum.isEven()) {
            System.out.println(num + " is even.");
        } else {
            System.out.println(num + " is odd.");
        }
    }
}

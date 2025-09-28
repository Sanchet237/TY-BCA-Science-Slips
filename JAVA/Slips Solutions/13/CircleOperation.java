/*Q2. Define an interface “Operation” which has methods area(),volume(). Define a constant PI 
having value 3.142. Create a class circle (member – radius) which implements this interface. 
Calculate and display the area and volume. [20 Marks]   */

import java.util.Scanner;

interface Operation {
    double PI = 3.142; 

    double area();   
    double volume(); 
}

class Circle implements Operation {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return PI * radius * radius;
    }

    @Override
    public double volume() {
        return (4.0 / 3) * PI * radius * radius * radius; 
    }
}

public class CircleOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius: ");
        double r = sc.nextDouble();

        Circle c = new Circle(r);

        System.out.println("Area of Circle: " + c.area());
        System.out.println("Volume of Sphere: " + c.volume());
    }
}

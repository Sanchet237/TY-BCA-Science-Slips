/*Q2. Create an abstract class Shape with methods area & volume. Derive a class Sphere (radius). 
Calculate and display area and volume. [20 Marks] */

import java.util.Scanner;

abstract class Shape {
    abstract double area();
    abstract double volume();
}

class Sphere extends Shape {
    double radius;

    Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    double volume() {
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter radius of the sphere: ");
        double radius = scanner.nextDouble();

        Sphere sphere = new Sphere(radius);

        System.out.printf("Surface Area of Sphere: %.2f\n", sphere.area());
        System.out.printf("Volume of Sphere: %.2f\n", sphere.volume());

        scanner.close();
    }
}
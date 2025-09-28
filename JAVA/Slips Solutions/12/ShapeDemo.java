/*Q2. Create an abstract class Shape with methods area & volume. Derive a class Cylinder (radius, 
height). Calculate area and volume. [20 Marks]  */

abstract class Shape {
    abstract double area();
    abstract double volume();
}

class Cylinder extends Shape {
    double radius;
    double height;

    Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    double area() {
        return 2 * Math.PI * radius * (radius + height); 
    }

    @Override
    double volume() {
        return Math.PI * radius * radius * height;
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(5, 10); 
        System.out.println("Cylinder Surface Area: " + cylinder.area());
        System.out.println("Cylinder Volume: " + cylinder.volume());
    }
}

/*Q2. Define a “Point” class having members – x,y (coordinates). Define default constructor and 
parameterized constructors. Define subclass “ColorPoint” with member as color. Write display 
method to display the details of Point. [20 Marks]  */

class Point {
    int x, y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void display() {
        System.out.println("Point Coordinates: (" + x + ", " + y + ")");
    }
}

class ColorPoint extends Point {
    String color;

    ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    void display() {
        System.out.println("Point Coordinates: (" + x + ", " + y + "), Color: " + color);
    }
}

public class PointDemo {
    public static void main(String[] args) {
        Point p1 = new Point();
        Point p2 = new Point(10, 20);
        ColorPoint cp = new ColorPoint(5, 15, "Red");

        p1.display();
        p2.display();
        cp.display();
    }
}

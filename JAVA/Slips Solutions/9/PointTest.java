/*Q2. Define a “Point” class having members – x,y(coordinates). Define default constructor and 
parameterized constructors. Define subclass “Point3D” with member as z (coordinate). Write 
display method to show the details of Point. [20 Marks] */

class Point {
    protected int x, y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void display() {
        System.out.println("Point coordinates: (" + x + ", " + y + ")");
    }
}

class Point3D extends Point {
    private int z;

    public Point3D() {
        super();
        z = 0;
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public void display() {
        System.out.println("Point3D coordinates: (" + x + ", " + y + ", " + z + ")");
    }
}

public class PointTest {
    public static void main(String[] args) {
        Point p1 = new Point();
        p1.display();

        Point p2 = new Point(5, 10);
        p2.display();

        Point3D p3 = new Point3D();
        p3.display();

        Point3D p4 = new Point3D(3, 6, 9);
        p4.display();
    }
}

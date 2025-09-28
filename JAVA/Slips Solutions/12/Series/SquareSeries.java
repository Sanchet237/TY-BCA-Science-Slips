package Series;

public class SquareSeries {
    public void printSeries(int n) {
        System.out.println("Square Series of " + n + " terms:");
        for (int i = 1; i <= n; i++) {
            System.out.print((i * i) + " ");
        }
        System.out.println();
    }
}

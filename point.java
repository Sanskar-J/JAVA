import java.lang.Math;
import java.util.Scanner;

public class point {
    int x;
    int y;
    static Scanner sc = new Scanner(System.in);

    point() {
    }

    point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    double calcDistance(point x, point y) {
        return Math.sqrt((Math.pow(x.x - y.x, 2) + Math.pow(x.y - y.y, 2)));
    }

    boolean checkRect(point w, point x, point y, point z) {

        double d1 = calcDistance(w, x);
        double d2 = calcDistance(x, y);
        double d3 = calcDistance(y, z);
        double d4 = calcDistance(z, w);
        if (d1 == d3 && d2 == d4)
            return true;
        else
            return false;
    }

    boolean checkSquare(point w, point x, point y, point z) {
        double d1 = calcDistance(w, x);
        double d2 = calcDistance(x, y);
        double d3 = calcDistance(y, z);
        double d4 = calcDistance(z, w);
        if (d1 == d2 && d2 == d3 && d3 == d4)
            return true;
        else
            return false;
    }

    point enterCord() {
        System.out.println("Enter Coordinates");
        int x = sc.nextInt();
        int y = sc.nextInt();
        point p = new point(x, y);
        return p;
    }

    public static void main(String args[]) {
        point x = new point();
        point c1 = x.enterCord();
        point c2 = x.enterCord();
        point c3 = x.enterCord();
        point c4 = x.enterCord();
        if (c4.checkRect(c1, c2, c3, c4))
            System.out.println("Hai");
        else
            System.out.println("nahi h");

    }
}
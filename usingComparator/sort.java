import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.text.html.HTMLDocument.RunElement;

class Pair {
    int x, y;

    Pair() {
    }

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}

class sortX implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        return a.x - b.x;
    }

}

class sortY implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        return a.y - b.y;
    }

}

// lets similarly try comparable also
class Student implements Comparable<Student> {
    int rno, ht, wt;

    Student() {
    }

    Student(int rno, int ht, int wt) {
        this.rno = rno;
        this.ht = ht;
        this.wt = wt;
    }

    public int compareTo(Student a) {
        return this.ht - a.ht;
    }

    public String toString() {
        return "[Rollno.:" + this.rno + " Height:" + this.ht + " Weight:" + this.wt + "]";
    }
}

class sort {
    public static void main(String[] args) {
        Pair arr[] = new Pair[4];
        arr[0] = new Pair(3, 5);
        arr[1] = new Pair(4, 8);
        arr[2] = new Pair(2, 17);
        arr[3] = new Pair(12, 15);
        Arrays.sort(arr, new sortY());
        for (Pair k : arr) {
            System.out.println(k.toString());
        }
        Arrays.sort(arr, new sortX());
        for (Pair k : arr) {
            System.out.println(k.toString());
        }
        System.out.println();

        Student check[] = new Student[4];
        check[0] = new Student(29, 150, 45);
        check[1] = new Student(44, 170, 58);
        check[2] = new Student(66, 169, 70);
        check[3] = new Student(43, 160, 65);

        // orignal array
        for (Student a : check)
            System.out.println(a.toString());
        // sort according to height as comparable interface
        System.out.println();
        Arrays.sort(check);
        for (Student a : check)
            System.out.println(a.toString());
        // reverse order
        System.out.println();
        Arrays.sort(check, Collections.reverseOrder());
        for (Student a : check)
            System.out.println(a.toString());
        // sorting a specified range
        Arrays.sort(check, 0, 3);
        System.out.println();
        for (Student a : check)
            System.out.println(a.toString());

        // max chain problem
        Pair a[] = new Pair[5];
        a[0] = new Pair(5, 24);
        a[1] = new Pair(39, 60);
        a[2] = new Pair(15, 28);
        a[3] = new Pair(27, 40);
        a[4] = new Pair(50, 90);

        System.out.println(maxChain(a, 5, 0, 0));

    }

    static int maxChain(Pair arr[], int n, int i, int j) {
        // Arrays.sort(arr,new sortX());
        if (j >= n)
            return 0;
        if (arr[j].x <= i)
            return maxChain(arr, n, i, j + 1);
        else {
            int ans = Math.max(maxChain(arr, n, arr[j].y, 0) + 1,
                    maxChain(arr, n, i, j + 1));

            return ans;
        }
    }
}
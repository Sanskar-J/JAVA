import java.util.*;

public class tugOfWar {
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int arr[] = { 23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4 };
        int n = arr.length;
        boolean[] elementsSelected = new boolean[n];
        boolean[] soln = new boolean[n];

        int sum = 0;
        for (int x : arr)
            sum += x;
        tOW(arr, n, elementsSelected, soln, sum, 0, 0, 0);
        System.out.println("1st partition :");
        for (int i = 0; i < n; i++) {
            if (soln[i] == true)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("2nd partition :");
        for (int i = 0; i < n; i++) {
            if (soln[i] == false)
                System.out.print(arr[i] + " ");
        }
    }

    public static void tOW(int arr[], int n, boolean elementsSelected[], boolean soln[], int sum, int sumSoFar,
            int elsSelected, int currIndex) {
        if (currIndex == n)
            return;
        if ((n / 2 - elsSelected) > (n - currIndex))
            return;

        // when element is not selected
        tOW(arr, n, elementsSelected, soln, sum, sumSoFar, elsSelected, currIndex + 1);
        // when element is selected
        elementsSelected[currIndex] = true;
        elsSelected++;
        sumSoFar += arr[currIndex];

        if (elsSelected == n / 2) {
            if (Math.abs(sum / 2 - sumSoFar) < minDiff) {
                minDiff = Math.abs(sum / 2 - sumSoFar);
                for (int i = 0; i < n; i++)
                    soln[i] = elementsSelected[i];
            }
        } else
            tOW(arr, n, elementsSelected, soln, sum, sumSoFar, elsSelected, currIndex + 1);

        elementsSelected[currIndex] = false;
    }
}

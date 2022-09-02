import java.util.*;

public class fillZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nxn:");
        int n = sc.nextInt();
        System.out.println("Enter mat");
        int arr[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();
        }
        display(arr, n);
        System.out.println();
        furtherOptimized(arr,n);
        // optimizedMethod(arr, n);
        // bruteForce(arr, n);
        display(arr, n);

    }

    public static void display(int arr[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

    public static void bruteForce(int arr[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    for (int k = 0; k < n; k++) {
                        arr[i][k] = -1;
                        arr[k][j] = -1;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == -1)
                    arr[i][j] = 0;
            }
        }
    }

    public static void optimizedMethod(int arr[][], int n) {
        int iS[] = new int[n];
        int jS[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    iS[i] = -1;
                    jS[j] = -1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (iS[i] == -1 || jS[j] == -1) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void furtherOptimized(int arr[][], int n) {
        int col0 = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i][0] == 0)
                col0 = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    arr[0][j] = 0;
                    arr[i][0] = 0;
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (arr[i][0] == 0 || arr[0][j] == 0) {
                    arr[i][j] = 0;
                }
            }
            if (col0 == 0)
                arr[i][0] = 0;
        }
    }
}

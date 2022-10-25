import java.util.Scanner;

public class kungfuPanda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(maxDumpling(5, arr));
    }

    public static int maxDumpling(int n, int arr[]) {
        int max = 0;
        for (int i = 0; i < n; i++)
            max = Math.max(max, arr[i]);
        int count[] = new int[max + 1];
        for (int i = 0; i < n; i++) {
            count[arr[i]] += 1;
        }
        int result[] = new int[max + 1];
        for (int i = 1; i < max + 1; i++) {
            int k = Math.max(i - 2, 0);
            result[i] = Math.max(result[i - 1], i * count[i] + result[k]);
        }
        return result[max];
    }

}

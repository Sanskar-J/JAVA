import java.util.*;

class tripletSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n ");
        int n = sc.nextInt();
        System.out.println("Enter in array ");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println("Enter sum ");
        int x = sc.nextInt();

        System.out.println("RESULT : " + isPresent(arr, n, x));
    }

    public static boolean isPresent(int arr[], int n, int x) {
        for (int i = 0; i < n - 2; i++) {
            int tSum = x - arr[i];
            HashSet<Integer> hs = new HashSet<>();

            for (int j = i + 1; j < n; j++) {

                if (hs.contains(tSum - arr[j])) {
                System.out.println(arr[i] + " " + arr[j] + " " + (tSum - arr[j]));

                    return true;
                }
                hs.add(arr[j]);
            }

        }

        return false;
    }
}
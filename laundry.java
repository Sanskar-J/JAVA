import java.util.Scanner;

public class laundry {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int money=sc.nextInt();
        int n=sc.nextInt();
        int arr[] = new int[n];;
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        System.out.println(noNotes(money, n, arr));
    }

    public static int noNotes(int money, int n, int arr[]) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = money;
            int k = i;
            while (i < n && sum > 0) {
                sum = sum - arr[i];
                i++;
                count++;
            }
            if (sum == 0)
                return count;
            else {
                count = 0;
                i = k++;
            }
        }
        return count;
    }
}

import java.util.*;

public class collectWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        int n = sc.nextInt();
        System.out.println("Enter heights");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println("Max water area is :" + collect(arr, n));
    }

    public static int collect(int arr[], int n) {
        int waterCollected = 0;
        int lMax[] = new int[n];
        int rMax[] = new int[n];
        lMax[0] = arr[0];
        for (int i = 1; i < n; i++) 
            lMax[i] = Math.max(lMax[i - 1], arr[i]);
        rMax[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--)
            rMax[i]=Math.max(arr[i],rMax[i+1]);

            
        for (int i = 0; i < n; i++) {
            waterCollected+=Math.min(lMax[i],rMax[i])-arr[i];

        }
        return waterCollected;
    }

}

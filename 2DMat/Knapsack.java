import java.util.*;

public class Knapsack {
    public static void main(String a[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        int n = sc.nextInt();
        System.out.println("Enter units");
        int value[] = new int[n];
        for (int i = 0; i < n; i++)
            value[i] = sc.nextInt();

        System.out.println("Enter wts");
        int wts[] = new int[n];
        for (int i = 0; i < n; i++)
            wts[i] = sc.nextInt();

        System.out.println("Enter Capacity");
        int cap = sc.nextInt();

        int maxVal = Knapsack$01(value, wts, n, cap);
        System.out.println("Max Value is: " + maxVal);
        int maxVal2 = Knapsack$Unbounded(value, wts, n, cap);
        System.out.println("Unbounded Max Value is: " + maxVal2);
        int maxVal3 = KnapsackRecursive(value, wts, n, cap);
        System.out.println("01 Recursive Max Value is: " + maxVal3);
    }

    static int Knapsack$01(int value[], int wts[], int n, int cap) {
        int dp[][] = new int[n + 1][cap + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j >= wts[i - 1]) {
                    int rCap = j - wts[i - 1];
                    dp[i][j]=Math.max(dp[i-1][j],dp[i - 1][rCap] + value[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][cap];
    }
    static int KnapsackRecursive(int value[],int wts[],int n,int cap){
        if(cap==0 || n==0) return 0;
        if(wts[n-1]<=cap)
        return Math.max(value[n-1]+KnapsackRecursive(value, wts, n-1, cap-wts[n-1]),KnapsackRecursive(value, wts, n-1, cap));
        else
        return KnapsackRecursive(value, wts, n-1, cap);
    }

    static int Knapsack$Unbounded(int value[],int wts[],int n,int cap){
        int dp[]=new int[cap+1];
        dp[0]=0;
        for(int i=1;i<cap+1;i++){
            int max=0;
            for(int j=0; j<n;j++){
                
                if(wts[j]<=i){
                    int rbagc=i-wts[j];
                    int rbagv=dp[rbagc];
                    int tbagv=rbagv+value[j];
                    max=Math.max(max,tbagv);
                }
            }
            dp[i]=max;
        }
        return dp[cap];
      
    }
}

import java.util.Scanner;
public class CoinTimes {
    public static void main(String a[]){
        Scanner sc=new Scanner(System.in);
        // System.out.println("Enter no types");
        // int n=sc.nextInt();
        // System.out.println("Enter");
        // int arr[]=new int[n];
        // for(int i=0;i<n;i++){
        //     arr[i]=sc.nextInt();
        // }

        // System.out.println("Enter Target");
        // int tar=sc.nextInt();
        // Combination(arr,tar,n);
        // Permutation(arr,tar,n);
        
        System.out.println(nCr(5, 1));
    }
    public static void Combination(int arr[],int tar,int n){
        int dp[]=new int[tar+1];
        dp[0]=1;
        for(int i=0;i<n;i++){
            for(int j=arr[i];j<dp.length;j++){
                dp[j]+=dp[j-arr[i]];
            }
        }

        System.out.println("No. of ways are: "+dp[tar]);
    }
    public static int nCr(int n,int r){
        int dp[]=new int[n+1];
        dp[0]=1;
        for(int i=0;i<r;i++){
            for(int j=1;j<dp.length;j++){
                dp[j]+=dp[j-i];
            }
        }
        return dp[n];
    }
    public static void Permutation(int arr[],int tar,int n){
        int dp[]=new int[tar+1];
        dp[0]=1;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<n;j++){
                // if(arr[j])
            }
        }
        System.out.println("No. of ways are: "+dp[tar]);
    }
}

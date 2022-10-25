import java.util.Arrays;

public class longestIncreasingSubsequence {
    public static void main(String[] args) {
        int arr[]={1,6,2,9,37,5,25,102};
        int n=8;
        System.out.println(solve(arr,n,0,-1));
        int dp[]=new int[n+1];
        Arrays.fill(dp, -1);
        // System.out.println(solveDP(arr, n, 0, -1, dp));
    }
    public static int solve(int arr[],int n,int index,int prev){
        if(index==n) return 0;
        int len=0+solve(arr, n, index+1, prev);
        if(prev==-1 || arr[index]>arr[prev])
        len=Math.max(len,1+solve(arr, n, index+1, index));

        return len;

    }
    public static int solveDP(int arr[],int n,int index,int prev,int dp[]){
        if(dp[index]!=-1) return dp[index];
        if(index==n){
            dp[index]=0;
            return 0;
        }
        int len=solveDP(arr, n, index+1, prev, dp);
        if(prev==-1 || arr[index]>arr[prev])
        len=Math.max(len,1+solveDP(arr, n, index+1, index, dp));

        dp[index]=len;
        return len;
    }
}

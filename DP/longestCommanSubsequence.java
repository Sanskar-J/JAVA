import java.util.Arrays;

public class longestCommanSubsequence {
    static int dp[][]=new int[1001][1001];
    public static void main(String[] args) {
        String x="abcdgh";
        String y="abedfhr";
        int n=x.length();
        int m=y.length();
        for(int i=0;i<=n;i++) Arrays.fill(dp[i], 0, m+1, -1);
        
        System.out.println("Recursive approach: "+LCS_Recursive(x, y, n, m));
        System.out.println("Memoized Version: "+LCS_Memoized(x, y, n, m));
    }
    public static void display(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++)
            System.out.print(arr[i][j]+" ");
            System.out.println();
        }
    }
    public static int LCS_Recursive(String x,String y,int n,int m){//length of LCS
        //base condition
        if(n==0 || m==0) return 0;
        //choice diagram
        if(x.charAt(n-1)==y.charAt(m-1))
        return 1+LCS_Recursive(x, y, n-1, m-1);
        else return Math.max(LCS_Recursive(x, y, n-1, m),LCS_Recursive(x, y, n, m-1));
    }
    public static int LCS_Memoized(String x,String y,int n,int m){
        //base condition
        if(n==0||m==0)return 0;
        //check value if present in dp
        if(dp[n][m]!=-1)return dp[n][m];
        if(x.charAt(n-1)==y.charAt(m-1)){
            //store in matrix
            dp[n][m]=1+ LCS_Memoized(x, y, n-1, m-1);
            return dp[n][m];
        }
        else{
            dp[n][m]=Math.max(LCS_Memoized(x, y, n-1, m),LCS_Memoized(x, y, n, m-1));
            return dp[n][m];
        }
    }
}

import java.util.*;

public class MaxGold {
    public static void main(String argp[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter m and n");
        int m = sc.nextInt();
        int n = sc.nextInt();

        int mat[][] = new int[m][n];
        System.out.println("Enter mat vals: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                mat[i][j] = sc.nextInt();
        }
        int dp[][]=new int[m][n];
        for(int j=n-1;j>=0;j--)
        {
            for(int i=0;i<m;i++){
                if(j==n-1){
                    dp[i][j]=mat[i][j];
                }
                else if(i==0){
                    dp[i][j]=Math.max(dp[i+1][j+1],dp[i][j+1])+mat[i][j];
                }
                else if(i==n-1){
                    dp[i][j]=Math.max(dp[i-1][j+1],dp[i][j+1])+mat[i][j];
                }
                else{
                    dp[i][j]=Math.max(dp[i+1][j+1],Math.max(dp[i][j+1],dp[i-1][j+1]))+mat[i][j];
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            System.out.print(mat[i][j]+" ");
            System.out.println();
        }
        System.out.println("dp");
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            System.out.print(dp[i][j]+" ");
            System.out.println();
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,dp[i][0]);
        }
        System.out.println("Max: "+max);

    }
}

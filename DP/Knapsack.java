public class Knapsack {
    public static void main(String[] args) {
        int wt[]={100,50,20,10,5,2};
        int val[]={2,3,4,24};
        int W=5010;
        int n=6;
        // System.out.println($01Knapsack(wt, val, n, W));
        System.out.println(unboundedKnapsack(wt, wt, n, W));
    }
    
    public static int $01Knapsack(int wt[],int val[],int n,int W){
        int dp[][]=new int[n+1][W+1];
        for(int i=1;i<=n;i++){
            for(int j=0;j<=W;j++){
                if(wt[i-1]<=j)
                dp[i][j]=Math.max(dp[i-1][j],val[i-1]+dp[i-1][j-wt[i-1]]);
                else dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][W];
    }
    public static int unboundedKnapsack(int wt[],int val[],int n,int W){
        int dp[][]=new int[n+1][W+1];
        for(int i=1;i<=n;i++){
            for(int j=0;j<=W;j++){
                if(wt[i-1]<=j)
                dp[i][j]=Math.max(dp[i-1][j],val[i-1]+dp[i][j-wt[i-1]]);
                else dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][W];
    }
}

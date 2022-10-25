public class coinChange {
    public static void main(String[] args) {
        int coins[]={3,5,7};
        int sum=10;
        int n=3;
        System.out.println(coinChange_I(coins, sum, n));
        System.out.println(coinChange_II(coins, sum, n));

    }
    public static void display(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++)
            System.out.print(arr[i][j]+" ");
            System.out.println();
        }
    }
    public static int coinChange_I(int coins[],int sum,int n)// max no. of ways that can be choosen
    {
        int dp[][]=new int[n+1][sum+1];
        for(int i=1;i<=n;i++) dp[i][0]=1;

        display(dp);
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(coins[i-1]<=j)
                dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                else dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
    public static int coinChange_II(int coins[],int sum,int n)// min no. of coins needed
    {
        int dp[][]=new int [n+1][sum+1];
        for(int i=1;i<=n;i++) dp[i][0]=0;
        for(int j=0;j<=sum;j++) dp[0][j]=Integer.MAX_VALUE-1;
        for(int j=1;j<=sum;j++){
            if(j%coins[0]==0)dp[1][j]=j/coins[0];
            else dp[1][j]=Integer.MAX_VALUE-1;
        }
        display(dp);
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(coins[i-1]<=j)
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                else dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
}

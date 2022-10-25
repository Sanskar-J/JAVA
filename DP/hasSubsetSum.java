import java.util.ArrayList;
// knapsack variants
public class hasSubsetSum {
    public static void main(String[] args) {
        // int arr[]={2,3,8,9,10};
        int arr[]={1,1,2,3};
        // int n=5;
        int n=4;
        int diff=1;
        int sum=11;
        System.out.println(hasSum(arr,sum,n));
        System.out.println(hasEqualSumPartition(arr, n));
        System.out.println(countSubsetSum(arr, sum,n));
        System.out.println(minimumSubsetSumDifference(arr, n));
        System.out.println(countSubsetGivenDifference(arr, n, diff));
    }
    public static void display(boolean arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++)
            System.out.print(arr[i][j]+" ");
            System.out.println();
        }
    }
    public static boolean hasSum(int arr[],int sum,int n){
        boolean dp[][]=new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }
        //ArrayList<Integer> al=new ArrayList<>();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++)
            {
                if(arr[i-1]<=j){
                dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
                //if(dp[i-1][j-arr[i-1]]==true)
                //al.add(arr[i-1]);
                }
                else dp[i][j]=dp[i-1][j];
                
            }
        }
        //System.out.println(al);
        return dp[n][sum];
    }
    public static boolean[] lastRow(int arr[],int sum,int n){
        boolean dp[][]=new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }
        //ArrayList<Integer> al=new ArrayList<>();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++)
            {
                if(arr[i-1]<=j){
                dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
                //if(dp[i-1][j-arr[i-1]]==true)
                //al.add(arr[i-1]);
                }
                else dp[i][j]=dp[i-1][j];
                
            }
        }
        //System.out.println(al);
        return dp[n];
    }
    public static int countSubsetSum(int arr[],int sum,int n){
        int dp[][]=new int[n+1][sum+1];
        for(int i=0;i<=n;i++)dp[i][0]=1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(arr[i-1]<=j)
                dp[i][j]=dp[i-1][j]+dp[i-1][j-arr[i-1]];
                else dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
    public static boolean hasEqualSumPartition(int arr[],int n){
        int sum=0;
        for(int x:arr)
        sum+=x;
        // System.out.println(sum/2);
        if(sum%2==0)return hasSum(arr, sum/2, n);
         return false;
        
    }
    public static int minimumSubsetSumDifference(int arr[],int n){
        int sum=0;
        for(int x: arr)sum+=x;
        boolean[]res=lastRow(arr, sum, n);
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=0;i<=sum/2;i++){
            if(res[i]==true) al.add(i);
        }
        System.out.println(al);
        return Math.abs(sum-2*al.get(al.size()-1));
    }
    public static int countSubsetGivenDifference(int arr[],int n,int diff){
        int sum=0;
        for(int x:arr)sum+=x;
        int subsetSum1=(sum+diff)/2;
        return countSubsetSum(arr, subsetSum1, n);
    }
}

public class maxSumIncreasingSubsequence {
    static int maxSum=0;
    public static void main(String[] args) {
        int arr[]={1,57,9,10,48,12,37,101};
        int n=8;
        int dp[]=new int[n];
        int oMax=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            Integer max=null;
            for(int j=0;j<i;j++)
                if(arr[j]<=arr[i])
                    if(max==null || dp[j]>max) max=dp[j];
            if(max==null) dp[i]=arr[i];
            else dp[i]=max+arr[i];
            oMax=Math.max(dp[i],oMax);
        }
        System.out.println(oMax);

        // solve(arr,n,1,0);
        System.out.println(maxSum);
    }
    public static void solve(int arr[],int n,int index,int sumSoFar){
        if(index==n)
        {
            maxSum=Math.max(maxSum,sumSoFar);
            return;
        }
        // sumSoFar+=arr[index];
        if(arr[index]>=arr[index-1])
        solve(arr, n, index+1, sumSoFar+arr[index-1]);
        else
        solve(arr, n, index+1, sumSoFar);

    }
}

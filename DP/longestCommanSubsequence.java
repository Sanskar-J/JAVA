import java.util.Arrays;

public class longestCommanSubsequence {
    static int dp[][]=new int[1001][1001];
    public static void main(String[] args) {
        String x="abcdea";
        String y="abdfcgea";
        int n=x.length();
        int m=y.length();
        for(int i=0;i<=n;i++) Arrays.fill(dp[i], 0, m+1, -1);
        
        System.out.println("Recursive approach: "+LCS_Recursive(x, y, n, m));
        System.out.println("Memoized Version: "+LCS_Memoized(x, y, n, m));
        System.out.println("Top-Down Version: "+LCS_TopDown(x, y, n, m));
        System.out.println("LCS print: "+printLCS(x, y, n, m));
        System.out.println("Longest Comman Substring: "+ longestCommanSubstring(x, y, n, m));
        System.out.println("Shortest Comman Supersequence: "+shortestCommanSupersequence("AGGTAB", "GXTXAYB", 6, 7));
        Pair IsDs=minimumInsertDeleteForXtoY("heap", "pea", 4, 3);
        System.out.println("No. of Inserts: "+IsDs.insert+" No. of Deletes: "+IsDs.delete);
        System.out.println("Longest Palindromic Subsequence: "+longestPalindromicSubsequence("abdcbae",7));
        System.out.println("No of deletions for converting a string into LPS: "+ minimumNoOfDeletionForLPS("agbcba", 6));
        // System.out.println("Print SCS: "+ printSCS("AGGTAB", "GXTXAYB", 6, 7));
        System.out.println("Print SCS: "+ printSCS("acbcf", "abcdaf", 5, 6));
        System.out.println("Length of longest repeating subsequence: "+ longestRepeatingSubsequence("AABBECDD", 8));
        System.out.println("Is Sequence Pattern Matching: "+isSequencePatternMatching("AXY", "ABCXY", 3, 5));
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
    public static int LCS_TopDown(String x,String y,int m,int n){
        int t[][]=new int[m+1][n+1];
        //initialization in java m==0 || n==0 already zero in java arrays
        //so directly inside loops
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(x.charAt(i-1)==y.charAt(j-1))
                t[i][j]=1+t[i-1][j-1];
                else t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
            }
        }
        return t[m][n];
    }
    public static String printLCS(String x,String y,int m,int n){
        int t[][]=new int [m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++)
                t[i][j]=x.charAt(i-1)==y.charAt(j-1)?1+t[i-1][j-1]:Math.max(t[i][j-1],t[i-1][j]);
        }
        StringBuilder s=new StringBuilder();
        int i=m,j=n;
        while(i>0&&j>0){
            if(x.charAt(i-1)==y.charAt(j-1)){
                s.insert(0, x.charAt(i-1));
                i--;j--;
            }
            else{
                if(t[i-1][j]>t[i][j-1])
                i--;
                else
                j--;
            }
        }
        return s.toString();
    }
    //now variations of LCS
    public static int longestCommanSubstring(String x,String y,int m,int n){
        int max=0;
        int t[][]=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(x.charAt(i-1)==y.charAt(j-1))
                t[i][j]=1+t[i-1][j-1];
                max=Math.max(max,t[i][j]);
            }
        }
        return max;
    }
    // length of shortest comman supersequence 
    public static int shortestCommanSupersequence(String x,String y,int m,int n){
        return m+n-LCS_TopDown(x, y, m, n);
    }
    // minimum insertion and deletion
    static class Pair{
        int insert,delete;
        Pair(){}
        Pair(int delete,int insert){
            this.insert=insert;
            this.delete=delete;
        }
    }
    public static Pair minimumInsertDeleteForXtoY(String x,String y,int m,int n){
        int LCS=LCS_TopDown(x,y,m,n);
        return new Pair(m-LCS,n-LCS);
    }
    // now longest palindromic subsequence seriously damn its getting easier
    public static int longestPalindromicSubsequence(String s,int n){
        StringBuilder rev=new StringBuilder(s);
        rev=rev.reverse();
        return LCS_TopDown(s, rev.toString(), n, n);
    }
    // minimum number of deletions to make a string LPS
    public static int minimumNoOfDeletionForLPS(String s,int n){//same as no. of insertions botha are =
        return n-longestPalindromicSubsequence(s, n);
    }
    // print SCS
    public static String printSCS(String x,String y,int m,int n){
        int t[][]=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++)
            t[i][j]=x.charAt(i-1)==y.charAt(j-1)?1+t[i-1][j-1]:Math.max(t[i-1][j],t[i][j-1]);
        }
        StringBuilder s=new StringBuilder();
        int i=m,j=n;
        while(i>0&&j>0){
            if(x.charAt(i-1)==y.charAt(j-1)){
                s.insert(0, x.charAt(i-1));
                i--;j--;
            }
            else{
                if(t[i][j-1]>t[i-1][j])
                {
                    s.insert(0, y.charAt(j-1));
                    j--;
                }
                else{
                    s.insert(0, x.charAt(i-1));
                    i--;
                }
            }
        }
        while(i>0){
            s.insert(0, x.charAt(i-1));
            i--;
        }
        while(j>0){
            s.insert(0, y.charAt(j-1));
            j--;
        }
        return s.toString();
    }
    // longest repeating subsequence
    public static int longestRepeatingSubsequence(String s,int n){
        int t[][]=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++)
                t[i][j]=s.charAt(i-1)==s.charAt(j-1)&&i!=j?1+t[i-1][j-1]:Math.max(t[i-1][j],t[i][j-1]);
        }
        return t[n][n];
    }
    // is sequence pattern matching
    public static boolean isSequencePatternMatching(String x,String y,int m,int n){
        return m==LCS_TopDown(x, y, m, n)?true:false;
    }
}

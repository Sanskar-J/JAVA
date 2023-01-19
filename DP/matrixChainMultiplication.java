import java.util.Arrays;
import java.util.HashMap;

public class matrixChainMultiplication {
    static int dp[][]=new int[1001][1001];
    static HashMap<String,Integer> hm=new HashMap<>();
    public static void main(String[] args) {
        int arr[]={40,20,30,10,30};
        for(int i=0;i<arr.length;i++){
            Arrays.fill(dp[i], 0, arr.length,-1);
        }
        System.out.println(MCM(arr, 1, arr.length-1));
        System.out.println(MCM_BottomUp(arr, 1, arr.length-1));
        String str="ababbbabbababa";
        System.out.println("Palindrom Partitioning: "+ palindromePartitioning(str, 0, str.length()-1));
        for(int i=0;i<str.length();i++){
            Arrays.fill(dp[i], 0, str.length(),-1);
        }
        System.out.println("Palindrome Partitioning DP: "+ palindromePartitioning_Memoization(str, 0,str.length()-1));
        for(int i=0;i<str.length();i++){
            Arrays.fill(dp[i], 0, str.length(),-1);
        }
        System.out.println("pP Memoization more optimized: "+pP_Memoization_Optimized(str, 0, str.length()-1));
        System.out.println("evaluate true: "+evaluateTrue("T|T&F^T", 0, 6, true));
        System.out.println("memoized evaluate true: "+memoizedEvaluateTrue("T|F^F&T|F^F^F^T|T&T^T|F^T^F&F^T|T^F", 0, 34, true));
        // System.out.println(hm);
        int egg=2,floor=10;
        System.out.println("Egg dropping recur method: "+eggDroppoing_Recursive(egg, floor));
        //egg dropping dp method memoization
        for(int i=0;i<=egg;i++){
            Arrays.fill(dp[i], 0, floor+1,-1);
        }
        System.out.println("Memoized egg dropping: "+eggDroppoing_Memoized(egg, floor));
    }
    public static int MCM(int arr[],int i,int j){
        if(i>=j) return 0;
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int tempAns=MCM(arr, i, k)+MCM(arr, k+1, j)+arr[i-1]*arr[k]*arr[j];
            min=Math.min(min,tempAns);
        }
        return min;
    }
    public static int MCM_BottomUp(int arr[],int i,int j){
        if(i>=j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int tempAns=MCM_BottomUp(arr, i, k)+ MCM_BottomUp(arr, k+1, j) + arr[i-1]*arr[k]*arr[j];
            min=Math.min(min,tempAns);
        }
        dp[i][j]=min;
        return dp[i][j];

    }
    // palindrome partitioning
    public static int palindromePartitioning(String s,int i,int j){
        if(i>=j) return 0;
        if(isPalindrome(s,i,j)) return 0;
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int tempAns=palindromePartitioning(s, i, k)+ palindromePartitioning(s, k+1, j) +1;
            min=Math.min(min,tempAns);
        }
        return min;
    }
    public static int palindromePartitioning_Memoization(String s,int i,int j){
        if(i>=j)return 0;
        if(isPalindrome(s, i, j))return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int tempAns=palindromePartitioning_Memoization(s, i, k)+ palindromePartitioning_Memoization(s, k+1, j) +1;
            min=Math.min(min,tempAns);
        }
        dp[i][j]=min;
        return dp[i][j];
    }
    public static int pP_Memoization_Optimized(String s,int i,int j){
        if(i>=j) return 0;
        if(isPalindrome(s, i, j)) return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int left,right;
            if(dp[i][k]!=-1) left=dp[i][k];
            else{
                left=pP_Memoization_Optimized(s, i, k);
                dp[i][k]=left;
            }
            if(dp[k+1][j]!=-1) right=dp[k+1][j];
            else{
                right=pP_Memoization_Optimized(s, k+1, j);
                dp[k+1][j]=right;
            }
            int tempAns=1+left+right;
            min=Math.min(min,tempAns);
        }
        dp[i][j]=min;
        return dp[i][j];
    }
    public static boolean isPalindrome(String s,int i,int j){
        String m=s.substring(i,j+1);
        StringBuilder k=new StringBuilder(m);
        k=k.reverse();
        if(m.equals(k.toString())) return true;
        return false;

    }
    // evaluate expression to true
    public static int evaluateTrue(String s,int i,int j,boolean isTrue){
        if(i>j)return 0;
        if(i==j){
            if(isTrue){
                if(s.charAt(i)=='T')return 1;
                else return 0;
            }
            else{
                if(s.charAt(i)=='F')return 1;
                else return 0;
            }
        }
        int ans=0;
        for(int k=i+1;k<=j-1;k+=2){
            int lT=evaluateTrue(s, i, k-1, true);
            int lF=evaluateTrue(s, i, k-1, false);
            int rT=evaluateTrue(s, k+1, j, true);
            int rF=evaluateTrue(s, k+1, j, false);
            if(s.charAt(k)=='|'){
                if(isTrue)
                ans+=(lT*rT)+(lF*rT)+(lT*rF);
                else
                ans+=lF*rF;
            }
            if(s.charAt(k)=='&'){
                if(isTrue)
                ans+=lT*rT;
                else
                ans+=(lF*rF)+(lF*rT)+(lT*rF);
            }
            if(s.charAt(k)=='^'){
                if(isTrue)
                ans+=(lT*rF)+(lF*rT);
                else
                ans+=(lT*rT)+(lF*rF);
            }
            
        }
        return ans;
    }
    public static int memoizedEvaluateTrue(String s,int i,int j,boolean isTrue){
        if(i>j) return 0;
        if(i==j){
            if(isTrue)
            return s.charAt(i)=='T'?1:0;
            else return s.charAt(i)=='F'?1:0;
        }
        String check=i+" "+j+" "+isTrue;
        if(hm.containsKey(check))
            return hm.get(check);
        int ans=0;
        for(int k=i+1;k<=j-1;k+=2){
            int lt,lf,rt,rf;
            if(hm.containsKey(i+" "+(k-1)+" "+true))
            lt=hm.get(i+" "+(k-1)+" "+true);
            else{
                lt=memoizedEvaluateTrue(s, i, k-1, true);
                hm.put(i+" "+(k-1)+" "+true, lt);
            }
            if(hm.containsKey(i+" "+(k-1)+" "+false))
            lf=hm.get(i+" "+(k-1)+" "+false);
            else{
                lf=memoizedEvaluateTrue(s, i, k-1, false);
                hm.put(i+" "+(k-1)+" "+false, lf);
            }
            if(hm.containsKey((k+1)+" "+j+" "+true))
            rt=hm.get(k+1+" "+j+" "+true);
            else{
                rt=memoizedEvaluateTrue(s, k+1, j, true);
                hm.put((k+1)+" "+j+" "+true, rt);
            }
            if(hm.containsKey((k+1)+" "+j+" "+false))
            rf=hm.get(k+1+" "+j+" "+false);
            else{
                rf=memoizedEvaluateTrue(s, k+1, j, false);
                hm.put((k+1)+" "+j+" "+false, rf);
            }
            if(s.charAt(k)=='|'){
                if(isTrue)
                ans+=(lt*rt)+(lf*rt)+(lt*rf);
                else
                ans+=lf*rf;
            }
            if(s.charAt(k)=='&'){
                if(isTrue)
                ans+=lt*rt;
                else
                ans+=(lf*rf)+(lf*rt)+(lt*rf);
            }
            if(s.charAt(k)=='^'){
                if(isTrue)
                ans+=(lt*rf)+(lf*rt);
                else
                ans+=(lt*rt)+(lf*rf);
            }

        }
        hm.put(i+" "+j+" "+isTrue, ans);
        return ans;
    }

    // egg dropping problem
    public static int eggDroppoing_Recursive(int e,int f){
        if(f==0 || f==1 || e==1)
        return f;
        int min=Integer.MAX_VALUE;
        for(int k=1;k<=f;k++){
            int tempAns=1+Math.max(eggDroppoing_Recursive(e-1,k-1),eggDroppoing_Recursive(e, f-k));
            min=Math.min(min,tempAns);
        }
        return min;
    }
    //memoized version
    public static int eggDroppoing_Memoized(int e,int f){
        if(f==0 || f==1 || e==1) return f;
        if(dp[e][f]!=-1)return dp[e][f];
        int min=Integer.MAX_VALUE;
        for(int k=1;k<=f;k++){
            int tempAns=1+Math.max(
                eggDroppoing_Memoized(e-1,k-1),
                eggDroppoing_Memoized(e, f-k)
            );
            min=Math.min(min,tempAns);
        }
        dp[e][f]=min;
        return min;
    }
}

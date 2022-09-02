import java.util.*;
public class LCS {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter s1");
        String s1=sc.nextLine();
        System.out.println("Enter s2");
        String s2=sc.nextLine();
        int dp[][]=new int [s1.length()+1][s2.length()+1];
        String s="";
        for(int i=dp.length-2;i>=0;i--){
            for(int j=dp[0].length-2;j>=0;j--){
                char c1=s1.charAt(i);
                char c2=s2.charAt(j);
                if(c1==c2){
                    dp[i][j]=dp[i+1][j+1]+1;
                    s=c1+s;
                }
                else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        System.out.println("LCS "+dp[0][0]+"   "+s);
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
    
}

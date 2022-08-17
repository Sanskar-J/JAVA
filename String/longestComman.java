import java.util.*;

public class longestComman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String :");
        String s1 = sc.next();
        String s2 = sc.next();
        sc.close();
        System.out.println(comman(s1, s2));
    }

    public static String comman(String s1, String s2) {
        int max = 0;int index=0;
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        // String s = "";
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);
                if (c1 != c2) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    // s += c1;
                }
                if(dp[i][j]>max)
                {
                    max=dp[i][j];
                    index=i;
                }
            }

        }
        for(int i=0;i<=s1.length();i++){
            for(int j=0;j<=s2.length();j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return s1.substring(index-max, index);

        
    }
}

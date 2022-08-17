import java.util.*;
public class GoldMine {
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

        // ArrayList<Integer> bag=new ArrayList<>();
        boolean visited[][]=new boolean[m][n];
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ArrayList<Integer> bag=new ArrayList<>();
                if(mat[i][j]!=0 && visited[i][j]==false){
                    maxGold(i,j,mat,bag,visited);
                }
                int sum=0;
                for( int val:bag)
                    sum+=val;
                
                    max=Math.max(sum,max);


            }
        }
        System.out.println("Max Gold collected is : "+max);
    }
    public static void maxGold(int i,int j,int a[][],ArrayList<Integer> bag,boolean visited[][]){
        if(i<0 || j<0 || i>=a.length || j>=a[0].length || visited[i][j]==true || a[i][j]==0)
        return;
        visited[i][j]=true;
        bag.add(a[i][j]);
        maxGold(i, j-1, a, bag, visited);
        maxGold(i+1, j, a, bag, visited);
        maxGold(i-1, j, a, bag, visited);
        maxGold(i, j+1, a, bag, visited);
    }
}

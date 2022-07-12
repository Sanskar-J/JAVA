import java.util.*;

class MinCost{
    public static void main(String a[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter m and n");
        int m=sc.nextInt();
        int n=sc.nextInt();

        int mat[][]=new int[m][n];
        System.out.println("Enter mat vals: ");
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            mat[i][j]=sc.nextInt();
        }

        int dMat[][]=new int[m][n];
      
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1){
                    dMat[i][j]=mat[i][j];
                }
                else if(i==m-1){
                    dMat[i][j]=mat[i][j]+dMat[i][j+1];
                }
                else if(j==n-1){
                    dMat[i][j]=mat[i][j]+dMat[i+1][j];
                }
                else{
                    dMat[i][j]=mat[i][j]+ Math.min(dMat[i][j+1],dMat[i+1][j]);
                }
            }
        }
        System.out.println("Main");
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            System.out.print(mat[i][j]+" ");
            System.out.println();
        }
        System.out.println("Minimum");
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            System.out.print(dMat[i][j]+" ");
            System.out.println();
        }
        System.out.println("Minimum Cost is: "+dMat[0][0]);
    }
}
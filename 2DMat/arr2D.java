import java.util.Scanner;
public class arr2D {
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
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            System.out.print(mat[i][j]+" ");
            System.out.println();
        }
    }
}

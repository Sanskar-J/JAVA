import java.util.*;

public class NQueens {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();
        int arr[][] = new int[n][n];
        nQs(arr, "", 0);
    }

    public static void nQs(int arr[][], String qsf, int row) {
        if (row == arr.length) {
            System.out.println(qsf+" . ");
            return;
        }
        for (int col = 0; col < arr.length; col++) {
            if (isQueenSafe(arr,row,col)) {
                arr[row][col] = 1;
                nQs(arr, qsf + row + "-" + col + ", ", row + 1);
                arr[row][col] = 0;
            }
        }
    }
    public static boolean isQueenSafe(int arr[][],int row,int col){
        for(int i=row-1,j=col;i>=0;i--){
            if(arr[i][j]==1)
            return false;
        }
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--)
        {
            if(arr[i][j]==1)
            return false;
        }
        for(int i=row-1,j=col+1;i>=0&&j<arr.length;i--,j++)
        {
            if(arr[i][j]==1)
            return false;
        }
        return true;
    }

}

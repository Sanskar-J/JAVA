import java.util.*;

public class NQueens {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();
        int arr[][] = new int[n][n];
        boolean board[][] = new boolean[n][n];
        nQs(arr, "", 0);
        // method 2 variables
        System.out.println("fast version");
        boolean [] cols=new boolean[n];
        boolean [] nDiag=new boolean[2*n-1];
        boolean [] rDiag=new boolean[2*n-1];
        solve(board,0,cols,nDiag,rDiag,"");
    }
    public static void solve(boolean board[][],int row,boolean[]cols,boolean[]nDiag,boolean[]rDiag, String asf){
        if(row==board.length){
            System.out.println(asf+".");
            return;
        }
        for(int col=0;col<board[0].length;col++){
            if(cols[col]==false 
            && nDiag[row+col]==false 
            && rDiag[row-col+board.length-1]==false){
                board[row][col]=true;
                cols[col]=true;
                nDiag[row+col]=true;
                rDiag[row-col+board.length-1]=true;
                solve(board,row+1,cols,nDiag,rDiag,asf+row+"-"+col+", ");
                cols[col]=false;
                nDiag[row+col]=false;
                rDiag[row-col+board.length-1]=false;
                board[row][col]=false;
            }
        }
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

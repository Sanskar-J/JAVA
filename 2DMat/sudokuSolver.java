import java.util.*;
public class sudokuSolver {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // int mat[][]=new int[9][9];
        int matw[][] = {
            { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
            { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
            { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
            { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
            { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
            { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
            { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
            { 0, 9, 0, 0, 0, 0, 4, 0, 0 } 
          };
        int mat[][]={
            {3 ,0 ,6 ,5 ,0 ,8 ,4 ,0 ,0},
             {5 ,2 ,0 ,0 ,0 ,0 ,0 ,0 ,0},
              {0 ,8 ,7 ,0 ,0 ,0 ,0 ,3 ,1},
               {0 ,0 ,3 ,0 ,1 ,0 ,0 ,8 ,0},
                {9 ,0 ,0 ,8 ,6 ,3 ,0 ,0 ,5},
                 {0 ,5 ,0 ,0 ,9 ,0 ,6 ,0 ,0},
                  {1 ,3 ,0 ,0 ,0 ,0 ,2 ,5 ,0},
                   {0 ,0 ,0 ,0 ,0 ,0 ,0 ,7 ,4},
                    {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        System.out.println("Enter sudoku");
        // for(int i=0;i<9;i++){
        //     for(int j=0;j<9;j++)
        //     mat[i][j]=sc.nextInt();
        // }
        solveSudoku(mat,0,0);
    }
    public static void solveSudoku(int mat[][],int i,int j){
        if(i==mat.length){
            display(mat);
            return;
        }
        int nextI=0,nextJ=0;
        if(j==mat[0].length-1){
            nextI=i+1;
            nextJ=0;
        }
        else{
            nextI=i;
            nextJ=j+1;
        }
        if(mat[i][j]!=0)
        solveSudoku(mat, nextI, nextJ);
        else{
            for(int k=1;k<=9;k++){
                if(isValid(mat, i, j, k)){
                    mat[i][j]=k;
                    solveSudoku(mat, nextI, nextJ);
                    mat[i][j]=0;
                }
            }
        }

    }
    public static boolean isValid(int mat[][],int x,int y,int value){
        for(int j=0;j<mat[0].length;j++){
            if(mat[x][j]==value)
            return false;
        }
        for(int i=0;i<mat.length;i++){
            if(mat[i][y]==value)
            return false;
        }
        int m=x/3*3;
        int n=y/3*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(mat[m+i][n+j]==value)
                return false;
            }
        }
        return true;
    }
    public static void display(int mat[][]){
        for(int i=0;i<mat[0].length;i++){
            for(int j=0;j<mat.length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}

import java.util.*;
class knightsTour{
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();
        int arr[][] = new int[n][n];
        System.out.println("Enter r and c: ");
        int r=sc.nextInt();
        int c=sc.nextInt();

        printKnightsPath(arr,r,c,1);
    }
    public static void printKnightsPath(int chess[][],int r,int c,int move){
        if(r<0 || c<0 || r>=chess.length || c>=chess.length || chess[r][c]>0){
            return;
        }
        else if(move==chess.length*chess.length){
            chess[r][c]=move;
            display(chess);
            // chess[r][c]=0;
            return;
        }
        chess[r][c]=move;
        printKnightsPath(chess,r-2,c+1,move+1);
        printKnightsPath(chess,r-1,c+2,move+1);
        printKnightsPath(chess,r+1,c+2,move+1);
        printKnightsPath(chess,r+2,c+1,move+1);
        printKnightsPath(chess,r+2,c-1,move+1);
        printKnightsPath(chess,r+1,c-2,move+1);
        printKnightsPath(chess,r-1,c-2,move+1);
        printKnightsPath(chess,r-2,c-1,move+1);
        chess[r][c]=0;
    }
    public static void display(int chess[][]){
        for(int i=0;i<chess.length;i++){
            for(int j=0;j<chess[0].length;j++){
                System.out.print(chess[i][j]+"  ");
            }
            System.out.println();
        }
    }

}
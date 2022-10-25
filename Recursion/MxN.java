import java.util.ArrayList;

public class MxN {
    static ArrayList<String>res=new ArrayList<>();
    public static void main(String[] args) {
        int mat[][] = { { 1, 2, 3 },
                        { 4, 5, 6 } };
        boolean visited[][]=new boolean[mat.length][mat[0].length];
        solve(mat,0,0,visited,"");

        System.out.println(res);

    }
    public static void solve(int mat[][],int i,int j,boolean visited[][],String answerSoFar){
        if(i>=mat.length || j>=mat[0].length || visited[i][j]==true)
        return;

        if(i==mat.length-1 && j==mat[0].length-1){
            res.add(answerSoFar+mat[i][j]);
            return;
        }
        visited[i][j]=true;
        solve(mat, i, j+1, visited, answerSoFar+mat[i][j]);
        solve(mat, i+1, j, visited, answerSoFar+mat[i][j]);
        visited[i][j]=false;
    }
}

public class longestRoute {
    static int max=0;
    public static void main(String[] args) {
        // int mat[][]=new int[3][8];
        int mat[][]={
            {1,1,1,1,1,1,1,1,1,1},
            {1,0,1,1,1,0,1,1,0,1},
            {1,1,1,1,1,1,1,1,1,1}
        };
        display(mat);
        System.out.println();
        boolean visited[][]=new boolean[3][10];
        traverse(mat, 0, 0,visited,0);
        System.out.println(max-1);
    }
    public static void traverse(int mat[][],int x,int y,boolean visited[][],int pathSoFar){
        if(x<0 || y<0 || x>=mat.length || y>=mat[0].length|| mat[x][y]==0|| visited[x][y]==true) return;
        visited[x][y]=true;
        traverse(mat, x+1, y, visited, pathSoFar+1);
        traverse(mat, x, y-1, visited, pathSoFar+1);
        traverse(mat, x, y+1, visited, pathSoFar+1);
        traverse(mat, x-1, y, visited, pathSoFar+1);
        visited[x][y]=false;
        max=Math.max(max,pathSoFar);
    }
    public static void display(int m[][]){
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
    }
}

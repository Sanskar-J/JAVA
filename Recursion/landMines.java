public class landMines {
    static int minPath = Integer.MAX_VALUE;

    public static void main(String[] args) {

        int[][] mat = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 } };
        display(mat);
        System.out.println();
        markUnsafeCells(mat);
        display(mat);
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        // System.out.println(mat.length+" , "+mat[1][1]);
        for(int i=0;i<mat.length;i++){
        findShortestPath(mat,i,0,visited,0);
        }
        System.out.println(minPath);
    }

    public static void markUnsafeCells(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    if (i > 0)
                        mat[i - 1][j] = 2;
                    if (i < mat.length - 1)
                        mat[i + 1][j] = 2;
                    if (j < mat[0].length-1)
                        mat[i][j + 1] = 2;
                    if (j > 0)
                        mat[i][j - 1] = 2;

                }
            }
        }
    }

    public static void findShortestPath(int mat[][], int x, int y, boolean visited[][], int pathSoFar) {
        if(y==mat[0].length-1){
            minPath=Math.min(minPath,pathSoFar);
            return;
        }
        if (x < 0 || y < 0 || x >= mat.length || y >= mat[0].length ||mat[x][y]==0 || visited[x][y] == true)
            return;
        if(mat[x][y]==2)
        return;
        
        visited[x][y]=true;
        // System.out.print(y+" ");
        findShortestPath(mat, x-1, y, visited, pathSoFar+1);
        findShortestPath(mat, x, y+1, visited, pathSoFar+1);
        findShortestPath(mat, x, y-1, visited, pathSoFar+1);
        findShortestPath(mat, x+1, y, visited, pathSoFar+1);
        visited[x][y]=false;
    }

    public static void display(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

}

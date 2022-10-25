public class kingGeorge {
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args) {
        // int arr[][]={{1, -1, -1,-1},{0,0,0,0},{0,0,-1,0},{0,0,-1,2}};
        int arr[][]={{1, -1, -1,-1,-1},{0,-1, -1,-1,-1},{0,-1,0,0,0},{0,-1,0,-1,0},{0,0,0,-1,2}};
        int n=5;
        boolean visited[][]=new boolean[n][n];
        traverse(arr,n,0,0,visited,0);
        System.out.println(min+1);
    }
    public static void traverse(int arr[][],int n,int x,int y,boolean v[][],int dist){
        if(x<0 || y<0 || x>=n || y>=n || arr[x][y]==-1||v[x][y]==true )
        return;
        if(arr[x][y]==2)
        {
            min=Math.min(min,dist);
            return;
        }
        v[x][y]=true;
        traverse(arr, n, x-1, y, v, dist+1);
        traverse(arr, n, x, y-1, v, dist+1);
        traverse(arr, n, x, y+1, v, dist+1);
        traverse(arr, n, x+1, y, v, dist+1);
        v[x][y]=false;

    }
}

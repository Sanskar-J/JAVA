public class BellmanFord {
    public static void main(String[] args) {
        int mat[][]={
            {0,2,-1},
            {1,0,-2},
            {2,1,3}
        };
        System.out.println(BellmanFordAlgo(mat, 3));
    }
    public static boolean BellmanFordAlgo(int mat[][],int n){
        int dist[]=new int[n];
        for(int i=0;i<n;i++) dist[i]=Integer.MAX_VALUE;
        dist[0]=0;
        for(int i=1;i<=n-1;i++){
            for(int j=0;j<n;j++){
                if(dist[mat[j][0]]!=Integer.MAX_VALUE && dist[mat[j][0]]+mat[j][2]<dist[mat[j][1]])
                dist[mat[j][1]]=dist[mat[j][0]]+mat[j][2];
            }
        }
        for(int j=0;j<n;j++){
            if(dist[mat[j][0]]!=Integer.MAX_VALUE && dist[mat[j][0]]+mat[j][2]<dist[mat[j][1]])
            return true;
        }
        return false;
    }
}

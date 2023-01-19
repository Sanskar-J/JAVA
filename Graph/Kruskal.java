import java.util.*;
public class Kruskal {
    static class DisjointSet{
        int parent[],rank[],n;
        DisjointSet(){}
        DisjointSet(int n){
            this.n=n;
            this.parent=new int[n+1];
            this.rank=new int[n+1];
            for(int i=1;i<=n;i++)
                this.parent[i]=i;
            
        }
        int findParent(int Node){
            if(Node==parent[Node]) return Node;
            return parent[Node]=findParent(parent[Node]);
        }
        void union(int u,int v){
            u=findParent(u);
            v=findParent(v);
            if(rank[u]<rank[v])
            parent[u]=v;
            else if(rank[u]>rank[v])
            parent[v]=u;
            else{
                parent[v]=u;
                rank[u]++;
            }
        }
    }
    static class Trio implements Comparable<Trio>{
        int wt,u,v;
        Trio(){}
        Trio(int wt,int u,int v){
            this.wt=wt;
            this.u=u;
            this.v=v;
        }

        public int compareTo(Trio a) {
            return this.wt-a.wt;
        }
        public String toString(){
            return "[wt: "+this.wt+", u: "+this.u+", v: "+this.v+"]";
        }
        
    }
    public static void main(String[] args) {
        int n=5;
        ArrayList<Trio>adj=new ArrayList<>();
        adj.add(new Trio(2,0,1));
        adj.add(new Trio(6,0,3));
        adj.add(new Trio(8,1,3));
        adj.add(new Trio(3,1,2));
        adj.add(new Trio(5,1,4));
        adj.add(new Trio(7,2,4));
        KruskalAlgo(adj,n);
        KruskalSameImpDiffMethod(adj, n);
    }
    static void KruskalAlgo(ArrayList<Trio>adj,int n){
        Collections.sort(adj);
        // int parent[]=new int[n];
        // int rank[]=new int[n];

        // for(int i=0;i<n;i++){
        //     parent[i]=i;
        //     rank[i]=0;
        // }
        DisjointSet ds=new DisjointSet(n);
        int costMst=0;
        //ArrayList<Trio>mst=new ArrayList<>();
        for(Trio x:adj){
            if(ds.findParent(x.u)!=ds.findParent(x.v)){
                costMst+=x.wt;
                ds.union(x.u,x.v);
            }
        }
        System.out.println(costMst);
        //System.out.println(mst);
        
    }
    static void KruskalSameImpDiffMethod(ArrayList<Trio>adj,int n){
        Collections.sort(adj);
        int parent[]=new int[n];
        int rank[]=new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
        int cost=0;
        for(Trio x:adj){
            if(findParent(x.u, parent)!=findParent(x.v, parent)){
                cost+=x.wt;
                union(x.u, x.v, parent, rank);
            }
        }
        System.out.println(cost);
    }
    static void union(int u,int v,int parent[],int rank[]){
        u=findParent(u,parent);
        v=findParent(v,parent);
        if(rank[u]<rank[v]){
            parent[u]=v;
        }
        else if(rank[v]<rank[u]){
            parent[v]=u;
        }
        else{
            parent[v]=u;
            rank[u]++;
        }
    }
    static int findParent(int u ,int parent[]){
        if(u==parent[u])return u;
        return findParent(parent[u], parent);
    }
}

import java.util.*;
class Solution
{
    static class Trio implements Comparable<Trio>{
        int wt,u,v;
        Trio(){}
        Trio(int wt,int u,int v){
            this.wt=wt;
            this.u=u;
            this.v=v;
        }
        public int compareTo(Trio a){   return this.wt-a.wt;    }
        public String toString(){   return "[wt:"+this.wt+", u:"+this.u+", v:"+this.v+"]";    }
    }
    static class DisjointSet{
        int parent[],rank[],n;
        DisjointSet(){}
        DisjointSet(int n){
            this.n=n;
            this.parent=new int[n+1];
            this.rank=new int[n+1];
            for(int i=1;i<=n;i++) this.parent[i]=i;
        }
        public int findParent(int u){
            if(u==parent[u])return u;
            return parent[u]=findParent(parent[u]);
        }
        public void union(int u,int v){
            u=findParent(u);
            v=findParent(v);
            if(rank[u]>rank[v]) parent[v]=u;
            else if(rank[u]<rank[v]) parent[u]=v;
            else{
                parent[v]=u;
                rank[v]++;
            }
        }
    }
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        //yeah kruskal baby
        ArrayList<Trio>al=new ArrayList<>();
        int i=0;
        for(ArrayList<ArrayList<Integer>>x:adj){
            
            for(ArrayList<Integer>y:x){
                al.add(new Trio(y.get(1),i,y.get(0)));
            }
            i++;
        }
        Collections.sort(al);
        DisjointSet ds=new DisjointSet(V);
        int cost=0;
        for(Trio x:al){
            if(ds.findParent(x.u)!=ds.findParent(x.v)){
                ds.union(x.u,x.v);
                cost+=x.wt;
            }
        }
        return cost;
    }
}

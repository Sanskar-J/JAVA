import java.util.*;
public class Prims {
    static class Pair implements Comparable<Pair>{
        int v,wt;
        Pair(){}
        Pair(int v,int wt){
            this.v=v;
            this.wt=wt;
        }
        @Override
        public int compareTo(Prims.Pair o) {
            // TODO Auto-generated method stub
            return this.wt-o.wt;
        }
        public String toString(){
            return "[v:"+this.v+", wt:"+this.wt+"]";
        }
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        ArrayList<Pair>t=new ArrayList<>();
        t.add(new Pair(1, 2));
        t.add(new Pair(3, 6));
        adj.add(t);
        ArrayList<Pair>t1=new ArrayList<>();
        t1.add(new Pair(3, 8));
        t1.add(new Pair(4, 5));
        t1.add(new Pair(2, 3));
        t1.add(new Pair(0, 2));
        adj.add(t1);
        ArrayList<Pair>t2=new ArrayList<>();
        t2.add(new Pair(1, 3));
        t2.add(new Pair(4, 7));
        adj.add(t2);
        ArrayList<Pair>t3=new ArrayList<>();
        t3.add(new Pair(0, 6));
        t3.add(new Pair(1, 8));
        adj.add(t3);
        ArrayList<Pair>t4=new ArrayList<>();
        t4.add(new Pair(1, 5));
        t4.add(new Pair(2, 7));
        adj.add(t4);
       // System.out.println(adj);
        System.out.println(PrimsAlgo(adj, 5));
    }
    static int PrimsAlgo(ArrayList<ArrayList<Pair>>adj,int n){
        int cost=0;
        int parent[]=new int[n];
        int key[]=new int[n];
        boolean MST[]=new boolean[n];
        Arrays.fill(parent,-1);
        Arrays.fill(key,Integer.MAX_VALUE);
        key[0]=0;
        PriorityQueue<Pair>pq=new PriorityQueue<Pair>(n);
        pq.add(new Pair(0, key[0]));
        for(int i=0;i<n-1;i++){
            Pair temp=pq.poll();
            MST[temp.v]=true;
            for(Pair x:adj.get(temp.v)){
                if(MST[x.v]==false && x.wt<key[x.v]){
                    parent[x.v]=temp.v;
                    key[x.v]=x.wt;
                    pq.add(new Pair(x.v, key[x.v]));
                }
            }
        }
        for(int x:key) cost+=x;
        return cost;
    }
}

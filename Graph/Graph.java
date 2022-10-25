import java.util.ArrayList;


class Graph{
    class Node{
        int v,wt;
        Node(){}
        Node(int v,int wt){
            this.v=v;
            this.wt=wt;
        }
        int getV(){
            return v;
        }
        int getWt(){
            return wt;
        }
    }
    static int V;
    static ArrayList<ArrayList<Node>> adj;
    Graph(){}
    Graph(int V){
        this.V=V;
        adj=new ArrayList<ArrayList<Node>>(V);
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<Node>());
        }
    }
    void addEdge(int u,int v,int wt){
        Node node1=new Node(v,wt);
        adj.get(u).add(node1);

        Node node2=new Node(u,wt);
        adj.get(v).add(node2);
    }
    static boolean pathMoreThanK(int src,int k){
        boolean visited[]=new boolean[V];
        visited[src]=true;

        return solve(src,k,visited);
    }
    static boolean solve(int src,int k,boolean visited[]){
        if(k<=0) return true;
        ArrayList<Node> it=adj.get(src);
        int index=0;
        for(int i=0;i<adj.get(src).size();i++)
        {
            Node currVertex=adj.get(src).get(i);
            int v=currVertex.v;
            int w=currVertex.wt;
            index++;
            if(visited[v]==true)
            continue;
            if(w>=k)
            return true;
            visited[v]=true;
            if(solve(v, k-w, visited)) return true;
            visited[v]=false;

        }
        return false;
    }
    public static void main(String[] args) {
        // create the graph given in above figure
    int V = 9;
    Graph g = new Graph(V);
 
    // making above shown graph
    g.addEdge(0, 1, 4);
    g.addEdge(0, 7, 8);
    g.addEdge(1, 2, 8);
    g.addEdge(1, 7, 11);
    g.addEdge(2, 3, 7);
    g.addEdge(2, 8, 2);
    g.addEdge(2, 5, 4);
    g.addEdge(3, 4, 9);
    g.addEdge(3, 5, 14);
    g.addEdge(4, 5, 10);
    g.addEdge(5, 6, 2);
    g.addEdge(6, 7, 1);
    g.addEdge(6, 8, 6);
    g.addEdge(7, 8, 7);
 
    int src = 0;
    int k = 62; 
    System.out.println(pathMoreThanK(src,k));
    k=60;
    System.out.println(pathMoreThanK(src,k));
    }
}
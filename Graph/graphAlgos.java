import java.util.ArrayList;
import java.util.*;

public class graphAlgos {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>(Arrays.asList( 2, 3,4,5,6,7)));
        graph.add(new ArrayList<>(Arrays.asList( 2, 3,4,5,7,8)));
        graph.add(new ArrayList<>(Arrays.asList(3,5,7,8,9)));
        graph.add(new ArrayList<>(Arrays.asList(4,7,8,9)));
        graph.add(new ArrayList<>(Arrays.asList(5)));
        graph.add(new ArrayList<>(Arrays.asList(7,9)));
        graph.add(new ArrayList<>(Arrays.asList(8)));
        graph.add(new ArrayList<>());
        graph.add(new ArrayList<>(Arrays.asList(9)));
        graph.add(new ArrayList<>());

        // ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        // graph.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        // graph.add(new ArrayList<>());
        // graph.add(new ArrayList<>(Arrays.asList(4)));
        // graph.add(new ArrayList<>());
        // graph.add(new ArrayList<>(Arrays.asList(3)));
        // graph.add(new ArrayList<>(Arrays.asList(4)));

        System.out.println(graph);

        System.out.println(bfsOfGraph(0, graph));
        System.out.println(dfsOfGraph(0, graph));
    }

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> al = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();
        // HashSet<Integer>hs=new HashSet<>();
        // boolean visited[]=new boolean[adj.size()];
        q.add(V);
        while (q.size() > 0) {
            int current = q.poll();
            if (al.contains(current))
                continue;
            al.add(current);
            for (int x : adj.get(current))
                q.add(x);

        }
        return al;
    }
    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> al=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        st.push(V);
        while(!st.isEmpty()){
            int current=st.pop();
            if(al.contains(current)) continue;
            al.add(current);
            for(int x: adj.get(current))
                st.push(x);
            
        }
        return al;
    }
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class traversals {
    static class Node {
        int data;
        Node left, right;

        Node() {
        }

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    static class Tuple{
        Node node; int vertical,level;
        Tuple(){}
        Tuple(Node node,int v,int l){
            this.node=node;
            this.vertical=v;
            this.level=l;
        }
    }

    static void levelOrderTraversal(Node root, ArrayList<Integer> res) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        res.add(root.data);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp.left != null) {
                res.add(temp.left.data);
                q.add(temp.left);
            }
            if (temp.right != null) {
                res.add(temp.right.data);
                q.add(temp.right);
            }
        }
    }
    static void verticalLevelOrderTraversal(Node root){
        Queue<Tuple>q=new LinkedList<>();
        q.add(new Tuple(root,0,0));
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>map=new TreeMap<>();
        while(!q.isEmpty()){
            Tuple temp=q.poll();
            if(!map.containsKey(temp.vertical))
            map.put(temp.vertical,new TreeMap<>());
            if(!map.get(temp.vertical).containsKey(temp.level))
            map.get(temp.vertical).put(temp.level,new PriorityQueue<>());
            map.get(temp.vertical).get(temp.level).add(temp.node.data);// damn that looks complex right itiwatiti

            if(temp.node.left!=null)
            q.add(new Tuple(temp.node.left,temp.vertical-1,temp.level+1));
            if(temp.node.right!=null)
            q.add(new Tuple(temp.node.right,temp.vertical+1,temp.level+1));
        }
        System.out.println(map);
        List<List<Integer>> list=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>>x:map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> y: x.values()){
                while(!y.isEmpty())
                list.get(list.size()-1).add(y.remove());
            }

        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        // Node root = new Node(0);
        // root.left = new Node(1);
        // root.left.left = new Node(3);
        // root.left.left.left = new Node(5);
        // root.left.right = new Node(4);
        // root.right = new Node(2);
        // root.right.left = new Node(6);
        // root.right.right = new Node(7);
        // root.right.right.right = new Node(8);
        // root.right.right.right.left = new Node(10);
        // root.right.right.right.right = new Node(9);
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        root.left.right.left=new Node(8);
        root.left.right.right=new Node(9);

        ArrayList<Integer> al = new ArrayList<>();
        levelOrderTraversal(root, al);
        System.out.println(al);
        verticalLevelOrderTraversal(root);
    }
}

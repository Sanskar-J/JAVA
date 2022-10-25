class Node{
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
public class treeDiameter {
    static class Pair{
        int ht,dia;
        Pair(){}
        Pair(int ht,int dia){
            this.ht=ht;
            this.dia=dia;
        }
    }
    public static void main(String[] args) {
        Node root;
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println(diameter(root));
    }
    // Function to return the diameter of a Binary Tree.
    static int diameter(Node root){
        Pair res=new Pair();
        res=solve(root);
        return res.dia;
    }
    static Pair solve(Node root){
        if(root==null)
            return new Pair(-1,0);
        Pair leftPair=solve(root.left);
        Pair rightPair=solve(root.right);
        int h=Math.max(leftPair.ht,rightPair.ht)+1;
        int d=Math.max(Math.max(leftPair.dia,rightPair.dia),leftPair.ht+rightPair.ht+3);
        return new Pair(h,d);
    }
    int diame(Node root) {
        if(root==null) return 0;
        int ld=diameter(root.left);
        int rd=diameter(root.right);
        int maxd=height(root.left)+height(root.right)+3;
        return Math.max(Math.max(ld,rd),maxd);
    }
    int height(Node root){
        return root==null?-1:Math.max(height(root.left),height(root.right))+1;
    }
}

class Node{
    Node left,right;
    int data;
    int maxLevel=-1;
    Node(int data){
        this.data=data;
        this.left=this.right=null;
    }
    void traverse(Node given){
        if(given == null)
        return;
        System.out.println(given.data);
        traverse(given.left);
        traverse(given.right);
    }
    void lView(Node given,int level){
        if(given == null)
        return;
        
        if(maxLevel<level)
        {
            System.out.print( " -> " + given.data);
            maxLevel=level;
        }
        lView(given.left,level+1);
        lView(given.right,level+1);

      
    }
    void rView(Node given,int level){
        if(given == null)
        return;
        if(maxLevel<level)
        {
            System.out.print( " -> " + given.data);
            maxLevel=level;
        }

        rView(given.right,level+1);
        rView(given.left,level+1);
    }

    void boundary(Node given){
        if(given==null)
        return;
        lView(given.left,0);
        System.out.print(" "+given.data+" ");
        maxLevel=-1;
        rView(given.right, 0);
    }
}
public class leftView {
    public static void main(String a[]){
        Node root=new Node(1);
        root.left=new Node(3);
        root.right=new Node(2);
        root.left.left=new Node(5);
        root.left.right=new Node(9);

        root.right.right=new Node(4);
        root.right.right.left=new Node(7);
        root.right.right.right=new Node(8);

        // root.lView(root, 0);
        root.boundary(root);
    }
}

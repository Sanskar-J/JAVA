class Node{
    int data;
    Node left, right;
 
    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class isItBst{
    static class BSTPair{
        boolean isBST;
        int min;
        int max;
    }
    static BSTPair _isBST(Node root){
        if(root==null){
            BSTPair res=new BSTPair();
            res.min=Integer.MAX_VALUE;
            res.max=Integer.MIN_VALUE;
            res.isBST=true;
            return res;
        }
        BSTPair lp= _isBST(root.left);
        BSTPair rp= _isBST(root.right);
        BSTPair mp=new BSTPair();
        mp.isBST=lp.isBST&&rp.isBST&&(root.data>=lp.max && root.data<=rp.min);
        mp.max=Math.max(root.data,Math.max(lp.max,rp.max));
        mp.min=Math.min(root.data,Math.min(lp.min,rp.min));
        return mp;
    }
    static boolean isBST(Node root)
    {
        BSTPair res=_isBST(root);
        return res.isBST;
    }
    public static void main(String[] args) {
        Node root;
        root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        System.out.println(isBST(root));
    }
}
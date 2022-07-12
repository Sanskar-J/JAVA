import java.util.*;
class Node{
    int data;
    ArrayList<Node> children=new ArrayList<>();
    
}
class GenericTree{
    static void levelOrderTraverse(Node node){
        Queue<Node>q=new ArrayDeque<>();
        Queue<Node>sq=new ArrayDeque<>();
        q.add(node);
        while(q.size()>0 ){
            node=q.remove();
            System.out.print(node.data+" ");
            for(Node child:node.children){
                sq.add(child);
                
            }
            if(q.size()==0){
                q=sq;
                sq=new ArrayDeque<>();
                System.out.println();
            }
           
            
        }
    }
    static void traverse(Node node){
        System.out.println("Node pre->"+ node.data);
        for(Node child:node.children){
            traverse(child);
        }
        System.out.println("Node post->"+ node.data);
    }
    static int height(Node node){
        int ht=-1;
        for(Node child:node.children){
            int ch=height(child);
            ht=Math.max(ht,ch);
        }
        ht++;
        return ht;
    }
    static void display(Node node){
        String str= node.data+"->";
        for(Node child:node.children){
            str+=child.data+",";
        }
        str+=".";
        System.out.println(str);
        for(Node child:node.children){
            display(child);
        }
    }
    public static void main(String args[]){
        int size=0;
        int[]arr={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root=new Node();
        Stack<Node> st=new Stack<>();
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==-1)
           { st.pop();size++;}
            else{
                Node temp=new Node();
                temp.data=arr[i];
                if(st.size()>0){
                st.peek().children.add(temp);
                
                }
                else{
                    root=temp;
                }
                st.push(temp);
            }
        }
        display(root);
        System.out.println("Size->"+size+" Height->"+ height(root));
        levelOrderTraverse(root);
    }
}
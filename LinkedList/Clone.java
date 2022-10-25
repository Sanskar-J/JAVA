import java.util.HashMap;
class Clone {
    class Node{
        int data;Node arb, next;
        Node(){}
        Node(int data){
            this.data=data;
            arb=next=null;
        }
    }
    // Function to clone a linked list with next and random pointer.
    Node copyList(Node head) {
        // your code here
        Node current = head;

        while (current != null) {
            Node t = current.next;
            current.next = new Node(current.data);
            current.next.next = t;
            current = t;
        }
        current = head;
        while (current != null) {
            if (current.arb != null)
                current.next.arb = current.arb.next;
            current = current.next.next;
        }
        Node orignal = head;
        Node copy = head.next;
        Node res = copy;
        while (orignal != null) {
            orignal.next = orignal.next.next;
            copy.next = copy.next != null ? copy.next.next : copy.next;
            //
            orignal = orignal.next;
            copy = copy.next;
        }
        return res;
    }
    // hashmap ka istemal karke
    Node copyUsingHashMap(Node head){
        HashMap<Node,Node> hm=new HashMap<>();
        Node curr=head;
        Node copy=new Node(-1);
        Node Rcopy=copy;
        while(curr!=null){
            copy.next=new Node(curr.data);
            hm.put(curr,copy.next);
            copy=copy.next;
            curr=curr.next;
        }
        curr=head;
        copy=Rcopy.next;
        while(curr!=null){
            if(curr.arb!=null)
                copy.arb=hm.get(curr.arb);
            copy=copy.next;
            curr=curr.next;
        }
        copy=Rcopy.next;
        return copy;
    }
}
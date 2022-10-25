import java.util.*;
public class FlattenLinkedList {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Node head=new Node(5);
        head.bottom=new Node(7);
        head.bottom.bottom=new Node(8);
        head.bottom.bottom.bottom=new Node(30);
        head.next=new Node(10);
        head.next.bottom=new Node(20);
        head.next.next=new Node(19);
        head.next.next.bottom=new Node(22);
        head.next.next.bottom.bottom=new Node(50);
        head.next.next.next=new Node(28);
        head.next.next.next.bottom=new Node(35);
        head.next.next.next.bottom.bottom=new Node(40);
        head.next.next.next.bottom.bottom.bottom=new Node(45);

        display(flatten(head));
    }
    
    public static void display(Node head){
        while(head!=null)
        {
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
    public static Node flatten(Node head){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        while(head!=null){
            Node temp=head;
            while(temp!=null){
                pq.add(temp.data);
                temp=temp.bottom;
            }
            head=head.next;
        }
        Node newHead=new Node(0);
        Node fuck=newHead;
        for(int i=0;i<pq.size();i++){
            fuck.next=new Node(pq.remove());
            fuck=fuck.next;
        }
        return newHead.next;
    }
}
class Node{
    Node bottom,next;
    int data;
    Node(){}
    Node(int data){
        this.data=data;
        next=null;
        bottom=null;
    }
}

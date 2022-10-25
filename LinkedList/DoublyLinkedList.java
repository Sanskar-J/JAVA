public class DoublyLinkedList {
    public static void main(String[] args) {
        Node head = null;
        head = insert(head, 5);
        head = insert(head, 4);
        head = insert(head, 3);
        head = insert(head, 2);
        head = insert(head, 1);
        // head = insert(head, 2);
        // head = insert(head, 1);
        int x = 11;

        // pairSum(x,head);
        // tripletSum(x, head);
        // display(rotateDoubly(head, 2));
        display(reverseKSizes(head, 2));
    }

    static Node insert(Node head, int data) {
        Node temp = new Node();
        temp.data = data;
        temp.next = temp.prev = null;
        if (head == null)
            (head) = temp;
        else {
            temp.next = head;
            (head).prev = temp;
            (head) = temp;
        }
        return temp;
    }
    public static void display(Node head){
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
    public static void pairSum(int x, Node head) {
        // boolean found=true;
        Node first = head;
        Node second = getLast(head);
        while (first != second && first.data < second.data) {
            int sum = first.data + second.data;
            if (sum == x)
                {
                    System.out.println(first.data + " , " + second.data);
                    first = first.next;
                    second = second.prev;
                }
            else
            {if (x > sum)
                first = first.next;
            else
                second = second.prev;}
        }
    }
    public static void tripletSum(int x, Node head){
        // Node curr=head;
        for(Node curr=head;curr!=null;curr=curr.next){
            int toFind=x-curr.data;
            System.out.print(curr.data+" , ");
            pairSum(toFind, curr.next);
            // curr=curr.next;
        }
    }
    public static Node getLast(Node x) {
        while (x.next != null)
            x = x.next;
        return x;
    }
    public static Node sort(Node head ,int k){
        if(head==null)
        return head;
        return head;
    }
    public static Node rotateDoubly(Node head,int n){
        Node temp=head;
        Node newHead=head;
        while(temp.next!=null)
        temp=temp.next;

        temp.next=head;
        while(n>0){
            newHead=newHead.next;
            n--;
        }
        newHead.prev.next=null;
        newHead.prev=null;
        
        return newHead;

    }
    public static Node reverseDLL(Node head){
        Node temp=null;
        Node curr=head;
        while(curr!=null){
            temp=curr.prev;
            curr.prev=curr.next;
            curr.next=temp;
            curr=curr.prev;
        }
        if(temp!=null)
        head=temp.prev;

        return head;
    }
    static Node push(Node head, Node new_node) 
    {
        // since we are adding at the beginning, 
        // prev is always NULL 
        new_node.prev = null;
  
        // link the old list off the new node
        new_node.next = head;
  
        // change prev of head node to new node 
        if (head != null)
            head.prev = new_node;
  
        // move the head to point to the new node 
        head = new_node;
        return head;
    }
    public static Node reverseKSizes(Node head,int k){
        Node current = head;
        Node next = null;
        Node newHead = null;
        int count = 0;
  
        // reversing the current group of k 
        // or less than k nodes by adding 
        // them at the beginning of list 
        // 'newHead'
        while (current != null && count < k)
        {
            next = current.next;
            newHead = push(newHead, current);
            current = next;
            count++;
        }
  
        // if next group exists then making the desired 
        // adjustments in the link 
        if (next != null)
        {
            head.next = reverseKSizes(next, k); 
            head.next.prev = head;
        }
  
        // pointer to the new head of the 
        // reversed group
        return newHead; 
    }
}

class Node {
    Node prev, next;
    int data;
    Node(){}
    Node(int data) {
        this.data = data;
    }
}

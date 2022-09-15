import org.w3c.dom.traversal.NodeFilter;

class Node{
    int data;
    Node next;
    Node(){}
    Node(int data){
        this.data=data;
    }
}
public class LinkedList{
    Node head;
    Node tail;
    int size=0;

    void addLast(int val){
        Node temp=new Node();
            temp.data=val;
        if(size==0){
            head = tail = temp;
        }else{
            
            tail.next=temp;
            tail=temp;
        }
        size++;
    }
    void addFirst(int val){
        Node temp=new Node();
        temp.data=val;
        if(size==0)
        {
            head=tail=temp;
        }
        else{
            temp.next=head;
            head=temp;
        }
        size++;
    }
    void addAt(int idx,int val){
        if(idx<0 || idx>=size){
            System.out.println("Invalid arguments");
        }
        else if(idx==0){
            addFirst(val);
        }
        else if(idx==size){
            addLast(val);
        }
        else{
            Node node=new Node();
            node.data=val;
            Node temp=head;
            for(int i=0;i<idx-1;i++)
            {
                temp=temp.next;
            }
            node.next=temp.next;
            temp.next=node;
            size++;
        }
    }
    boolean checkEmpty(){
        if(size==0) return true;
        return false;
    }
    void removeFirst(){
        if(size==0)
        System.out.println("List is empty");
        else if(size==1){
        head=tail=null;
        size=0;
        }
        else{
            head=head.next;
            size--;
        }
    }
    void removeLast(){
        if(size==0){
            System.out.println("List is empty");
        }
        else if(size==1){
            head=tail=null;
            size=0;
        }
        else{
            Node temp=head;
            for(int i=0;i<size-2;i++)
            {
                temp=temp.next;
            }
            temp.next=null;
            tail=temp;
            size--;
        }
    }
    void removeAt(int idx){
        if(idx<0 || idx>=size){
            System.out.println("Invalid arguments");
        }
        else if(idx==0){
            removeFirst();
        }
        else if(idx==size-1){
            removeLast();
        }
        else{
            Node temp=head;
            for(int i=0;i<idx-1;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
            size--;
        }
    }
    int getFirst(){
        if(size==0) {
            System.out.println("List is empty");
            return -1;
        }
        else{
            return head.data;
        }
    }
    int getLast(){
        if(size==0) {
            System.out.println("List is empty");
            return-1;
        }
        else{
            return tail.data;
        }
    }
    int getAt(int idx){
        if(size==0){
            System.out.println("List is empty");
            return -1;
        }
        else if(idx >= size || idx < 0 )
        {
            System.out.println("Invalid Arguments");
            return -1;
        }
        else{
            Node temp=head;
            for(int i=0;i<idx;i++){
                temp=temp.next;
            }
            return temp.data;
        }
    }
    int size()
    {
        return size;
    }
    void display(){
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
    }
    Node getNodeAt(int idx){
        Node temp=head;
        for(int i=0;i<idx;i++){
            temp=temp.next;
        }
        return temp;
    }
    void reverseLL(){
        int left=0;
        int right=size-1;
        while(left<right){
            Node nodeLeft=getNodeAt(left);
            Node nodeRight=getNodeAt(right);
            int temp=nodeLeft.data;
            nodeLeft.data=nodeRight.data;
            nodeRight.data=temp;
            left++; right--;
        }
    }
    Node reverseLL2(){
        if(head==null)
           return null;
        Node prev=null;
        Node curr=head;
        
        while(curr!=null)
        {
            
            Node temp=curr.next;
            curr.next=prev;
            prev=curr;
            System.out.print(prev.data+"    ");
            curr=temp;
            System.out.print("$$" +curr.data+"  $$  ");
            
        }
        return prev;
    }
    public static Node getTailNode(Node head){
        while(head.next!=null){
            head=head.next;
        }
        return head;
    }
    public static void displayLL(Node head){
        while(head!=null){
            if(head.next==null){
                System.out.print(head.data);
            }
            else{
                System.out.print(head.data+"->");
            }
            head=head.next;
        }
        System.out.println();
    }
    public static void main(String a[])
    {
        // LinkedList one=new LinkedList();
        // one.addLast(37);
        // one.addLast(39);
        // one.display();
        // System.out.println("Size: "+one.size());
        // one.removeFirst();
        // one.display();
        // System.out.println("Size: "+one.size());
        // one.addFirst(78);
        // one.addLast(56);
        // one.display();
        // System.out.println("Size: "+one.size());
        // System.out.println(one.getAt(0));
        // // one.reverseLL();
        // System.out.println(one.getAt(0));
        // one.display();
        // System.out.println("Size: "+one.size());
        // LinkedList check=new LinkedList();
        // check.head=one.reverseLL2();
        // check.display();

        Node head=new Node(5);
        head.next=new Node(2);
        head.next.next=new Node(1);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(3);
        displayLL(head);
        Node high=getTailNode(head);
        // qSortLL(head,head,high;);
        // Node hed[]=segregate(head, high);
        // displayLL(hed[0]);
        // displayLL(hed[1]);
        // displayLL(hed[2]);
        // displayLL(hed[3]);
        // Node ied[]=segregate(hed[0], getTailNode(hed[0]));
        // displayLL(ied[0]);
        // displayLL(ied[1]);
        // displayLL(ied[2]);
        Node k=qSort2(head, high);
        displayLL(k);
        
    }
    public static void qSortLL(Node head,Node low,Node high){
        if(low==null|| high==null ||low==high){
            return;
        }
        Node pivot=high;
        System.out.println(pivot.data+" "+low.data+" "+high.data );
        Node p=partitionInLinkedList(head,pivot,low,high);
        displayLL(p);
        qSortLL(head, low, p);
        qSortLL(head, p.next.next, high);
    }
    public static Node partitionInLinkedList(Node head,Node pivot,Node lo,Node hi){
        // Node pivot=getTailNode(head);
        Node low=lo;
        Node high=lo;
        while(low!=null && low!=hi.next){
            if(low.data>pivot.data){
                low=low.next;
            }
            else{
                int t=low.data;
                low.data=high.data;
                high.data=t;
                low=low.next;
                high=high.next;
            }
        }
        
        return pivot;
        // return head;
    }
    public static Node qSort2(Node head,Node pivot){

        
        Node p[]=segregate(head, pivot);
        if(p[0]==null || p[1] ==null || p[2]==null || p[3]==null){}
    
        p[3].next=p[2];
        p[2].next=p[1];
        return p[0];
        
    }
    public static Node[] segregate(Node head, Node pivot){
        Node lHalf=new Node(-99);
        Node rHalf=new Node(-99);
        Node p=null;
        Node headLeft=lHalf;
        Node headRight=rHalf;
        Node res[]=new Node[4];
        if(head==pivot){
            System.out.println("i reched here");
            res[0]=null;
        res[1]=null;
        res[2]=head;
        res[3]=head;
        return res;
        }
        while(head!=null){
            if(head.data<pivot.data){
                lHalf.next=head;
                lHalf=lHalf.next;
            }
            else if(head.data>pivot.data){
                rHalf.next=head;
                rHalf=rHalf.next;
            }
            else{
                p=head;
                p.next=null;
            }
            head=head.next;

        }
        rHalf.next=null;
        lHalf.next=null;

        // headLeft=headLeft.next;
        // lHalf.next=headRight.next;
        res[0]=headLeft.next;
        res[1]=headRight.next;
        res[2]=p;
        res[3]=lHalf;
        
        return res;

    }

}


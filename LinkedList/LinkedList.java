class Node{
    int data;
    Node next;
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
    public static void main(String a[])
    {
        LinkedList one=new LinkedList();
        one.addLast(37);
        one.addLast(39);
        one.display();
        System.out.println("Size: "+one.size());
        one.removeFirst();
        one.display();
        System.out.println("Size: "+one.size());
        one.addFirst(78);
        one.addLast(56);
        one.display();
        System.out.println("Size: "+one.size());
        System.out.println(one.getAt(0));
        // one.reverseLL();
        System.out.println(one.getAt(0));
        one.display();
        System.out.println("Size: "+one.size());
        LinkedList check=new LinkedList();
        check.head=one.reverseLL2();
        check.display();
        
    }
}


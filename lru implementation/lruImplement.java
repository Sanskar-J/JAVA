//{ Driver Code Starts
    import java.io.*;
    import java.util.*;
    import java.lang.*;
    
      public class lruImplement {
    
        public static void main(String[] args) throws IOException {
            BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
    
            int t = Integer.parseInt(read.readLine());
    
            while (t-- > 0) {
    
                int capacity = Integer.parseInt(read.readLine());
                int queries = Integer.parseInt(read.readLine());
                LRUCache cache = new LRUCache(capacity);
                String str[] = read.readLine().trim().split(" ");
                int len = str.length;
                int itr = 0;
    
                for (int i = 0; (i < queries) && (itr < len); i++) {
                    String queryType = str[itr++];
                    if (queryType.equals("SET")) {
                        int key = Integer.parseInt(str[itr++]);
                        int value = Integer.parseInt(str[itr++]);
                        cache.set(key, value);
                    }
                    if (queryType.equals("GET")) {
                        int key = Integer.parseInt(str[itr++]);
                        System.out.print(cache.get(key) + " ");
                    }
                }
                System.out.println();
            }
        }
    }
    
    // } Driver Code Ends
    
    
    // design the class in the most optimal way
    
    class LRUCache
    {
        static class Pair{
            int key,value;
            Pair(){
                
            }
            Pair(int key,int value){
                this.key=key;
                this.value=value;
            }
        }
        static class Node{
            Pair data;
            Node prev,next;
            Node(){
                
            }
            Node(int x,int y){
                this.data=new Pair(x,y);
                this.prev=this.next=null;
            }
        }
        static class Deque{
            Node head;
            Node tail;
            int size;
            Deque(){
                this.head=new Node();
                this.tail=new Node();
                this.head.next=this.tail;
                this.tail.prev=this.head;
                this.size=0;
            }
            void addFirst(Node temp){
                Node next=head.next;
                head.next=temp;
                temp.prev=head;
                temp.next=next;
                next.prev=temp;
                size++;
            }
            Node removeLast(){
                Node toRemove=tail.prev;
                Node beforeToRemove=tail.prev.prev;
                beforeToRemove.next=tail;
                tail.prev=beforeToRemove;
                size--;
                return toRemove;
            }
            void remove(Node temp){
                Node before=temp.prev;
                Node after=temp.next;
                before.next=after;
                after.prev=before;
                size--;
            }
        }
        static Deque lru;
        static HashMap<Integer,Node>hm;
        static int cap;
        //Constructor for initializing the cache capacity with the given value.
        LRUCache(int cap)
        {
            //code here
            this.cap=cap;
            this.hm=new HashMap<>();
            this.lru=new Deque();
            
        }
    
        //Function to return value corresponding to the key.
        public static int get(int key)
        {
            // your code here
            if(!hm.containsKey(key)) return -1;
            Node current=hm.get(key);
            lru.remove(current);
            lru.addFirst(current);
            return current.data.value;
        }
    
        //Function for storing key-value pair.
        public static void set(int key, int value)
        {
            // your code here
            Node temp;
            if(!hm.containsKey(key)){
                temp=new Node(key,value);
                hm.put(key,temp);
                lru.addFirst(temp);
                if(lru.size>cap){
                    Node rem=lru.removeLast();
                    hm.remove(rem.data.key);
                }
            }
            else{
                temp=hm.get(key);
                temp.data.value=value;
                lru.remove(temp);
                lru.addFirst(temp);
                
            }
        }
    }
    
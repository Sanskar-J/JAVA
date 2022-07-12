import java.util.ArrayList;

class PriorityQueue{
    ArrayList<Integer> data=new ArrayList<>();
    PriorityQueue(){
        data=new ArrayList<>();
    }
    public void add(int val){
        data.add(val);
        upHeapify(data.size()-1);
    }
    public int remove(){
        swap(0,data.size()-1);
        int removed=data.remove(data.size()-1);
        downHeapify(0);
        return removed;
    }
    public void upHeapify(int i){
        if(i==0)
        return;

        int parentIndex=(i-1)/2;
        if(data.get(parentIndex)>data.get(i)){
            swap(i,parentIndex);
            upHeapify(parentIndex);
        }
    }
    public void downHeapify(int pi){
        int min=pi;
        int leftChildIndex=2*pi+1;
        if(leftChildIndex<data.size() && data.get(leftChildIndex)<data.get(min)){
            min=leftChildIndex;
        }
        int rightChildIndex=2*pi+2;
        if(rightChildIndex<data.size() && data.get(rightChildIndex)<data.get(min)){
            min=rightChildIndex;
        }
        if(min !=pi){
            swap(pi, min);
            downHeapify(min);
        }
    }
    public void swap(int i,int j){
        int ith=data.get(i);
        int jth=data.get(j);
        data.set(i,jth);
        data.set(j,ith);
    }
    public void display(){
        for(int d:data){
            System.out.print(d+" ");
        }
    }
}
class Heap{
    public static void main(String a[])
    {
        PriorityQueue pq=new PriorityQueue();
        pq.add(25);
        pq.add(49);
        pq.add(36);
        pq.add(9);
        pq.add(16);
        pq.add(4);
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        pq.display();
    }
}
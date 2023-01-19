import java.io.*;
import java.util.*;
public class MyMap{
    public static class HashM<K,V>
    {
        private class HMNode{
            K key; 
            V value;
            HMNode(K key, V value){
                this.key=key;
                this.value=value;
            }
        }
         private int size;
         private LinkedList<HMNode> [] bucket;
         public HashM(){
            intibucket(4);
            size=0;
         }
         private void intibucket(int n){
            bucket=new LinkedList[n];
            for(int i=0;i<n;i++)
            bucket[i]=new LinkedList<>();
         }
         public void put(K key,V value) throws Exception{
            int bi=hashfn(key);
            int di=getIndexWithinBucket(key,bi);

            if(di!=-1){
                HMNode node=bucket[bi].get(di);
                node.value=value;
            }
            else{
                HMNode node=new HMNode(key,value);
                bucket[bi].add(node);
                size++;
            }

            double lambda=size*1.0/bucket.length;

            if(lambda > 2.0) rehash();

         }
         private int hashfn(K key){
            int hc=key.hashCode();
            return Math.abs(hc) % bucket.length;
         }
         private int getIndexWithinBucket(K key,int bi){
            int di=0;
            for(HMNode node: bucket[bi]){
                if(node.key.equals(key)) return di;
                di++;
            }
            return -1;
         }

         //contains key
         public boolean containsKey(K key){
            int bi=hashfn(key);
            int di=getIndexWithinBucket(key,bi);

            if(di!=-1){
                return true;
            }
            else{
                return false;
            }
         }
         //get 
         public V get(K key){
            int bi=hashfn(key);
            int di=getIndexWithinBucket(key,bi);

            if(di!=-1){
                return bucket[bi].get(di).value;
            }
            else{
                return null;
            }
         }
         //remove
         public V remove(K key){
            int bi=hashfn(key);
            int di=getIndexWithinBucket(key,bi);

            if(di!=-1){
                size--;
                return bucket[bi].remove(di).value;
            }
            else{
                return null;
            }
         }
         //size
         public int size(){
            return size;
         }
         //keyset
         public ArrayList<K> keyset() throws Exception{
            ArrayList<K>keys=new ArrayList<>();
            for(int i=0;i<bucket.length;i++){
                for(HMNode node:bucket[i]){
                    keys.add(node.key);
                }
            }
            return keys;
         }
         //rehash function
         private void rehash()throws Exception{
            LinkedList<HMNode> oldBucket[]=bucket;
            intibucket(oldBucket.length*2);

            for(int i=0;i<oldBucket.length;i++){
                for(HMNode node:oldBucket[i]){
                    put(node.key, node.value);
                }
            }
         }
         public String toString() {
            ArrayList<K> keys=new ArrayList<>();
            try {
                keys = keyset();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            StringBuilder s=new StringBuilder();
            s.append("[");
            for(K key:keys){
                s.append("["+key+","+get(key)+"]");
            }
            s.append("]");
            return s.toString();
         }
    }
    public static void main(String[] args) throws Exception {
        HashM<Integer,Integer>hm=new HashM<>();
        hm.put(1,1);
        hm.put(2,2);
        hm.put(3,4);
        System.out.println(hm);
    }
}

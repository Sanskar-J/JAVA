import java.util.*;
class treeImplement{
    static class Node{
        Node links[]=new Node[26];
        boolean flag=false;
        public Node(){}
        boolean containsKey(char ch){
            return links[ch- 'a']!=null;
        }
        void put(char ch,Node node){
            links[ch-'a']=node;
        }
        Node get(char ch){
            return links[ch-'a'];
        }
        void setEnd(){
            flag=true;
        }
        boolean isEnd(){
            return flag;
        }

    }
    static class Trie{
        Node root;
        Trie(){
            root=new Node();
        }
        void insert(String word){
            Node temp=root;
            for(int i=0;i<word.length();i++){
                if(!temp.containsKey(word.charAt(i))){
                    temp.put(word.charAt(i), new Node());
                }
                temp=temp.get(word.charAt(i));
            }
            temp.setEnd();
            // move to the new reference node 
        }
        boolean search(String word){
            Node temp=root;
            for(int i=0;i<word.length();i++){
                if(!temp.containsKey(word.charAt(i)))
                return false;
                temp=temp.get(word.charAt(i));
            }
            if(temp.isEnd()) return true;
            return false;
        }
        boolean startsWith(String word){
            Node temp=root;
            for(int i=0;i<word.length();i++){
                if(!temp.containsKey(word.charAt(i))) return false;
                temp=temp.get(word.charAt(i));
            }
            return true;
        }
    }
}
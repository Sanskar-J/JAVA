package Needs;

import java.util.Comparator;

public class Pair<T extends Comparable<T>,U extends Comparable<U>> implements Comparable<Pair<T,U>>{
    T x;
    U y;

    Pair(){
        this.x=null;
        this.y=null;
    }
    public Pair(T x,U y){
        this.x=x;
        this.y=y;
    }
    public String toString(){
        return "[x:"+this.x+", y:"+this.y+"]";
    }

    @Override
    public int compareTo(Pair<T,U> o) {
        // TODO Auto-generated method stub
        return this.x.compareTo(o.x);
    }
    
    public class SortY implements Comparator<Pair<T,U>> {
        @Override
        public int compare(Pair<T,U> a, Pair<T,U> b) {
            return a.y.compareTo(b.y);
        }
    }
}
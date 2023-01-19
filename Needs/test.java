import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import Needs.Pair;
import Needs.Pair.SortY;
public class test
{
  static int bSearch(int ab[],int b,int f,int l){
    int m=(l+f)/2;
    if(ab[m]==b)
    return m;
    else if(ab[m]<b){
      return bSearch(ab, b, m,l);
    }
    else{
      return bSearch(ab, b, f, m);
    }
  }
    public static void main(String []ar)
    {
      int x[]={1,2,3,4,5,6,7,8,9};
      // Scanner sc=new Scanner(System.in);
      // // test out=new test();
      //   b=sc.nextInt();
      // int x=sum(a,b);
      System.out.println(bSearch(x, 7, 0, 8));
      Pair<String,String> y=new Pair<>("A","B");
      Pair<Integer,Pair<Character,Integer>>z=new Pair<>(1,new Pair('a',987));
      ArrayList<Pair<Integer,Integer>>al=new ArrayList<>();
      ArrayList<Pair<Integer,Integer>>al2=new ArrayList<>();
      // al.get(0).sortX();
      
      al.add(new Pair(1,2));
      al.add(new Pair(5,9));
      al.add(new Pair(3,4));
      
      al.add(new Pair(2,7));

      al2.add(new Pair(1,2));
      al2.add(new Pair(5,9));
      al2.add(new Pair(3,4));
      
      al2.add(new Pair(2,7));


     
      Collections.sort(al);
      Collections.sort(al2, new SortY());
      System.out.println(al);
      System.out.println(al2);

    }
    
}
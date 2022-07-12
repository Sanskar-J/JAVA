import java.util.Scanner;
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

    }
    
}
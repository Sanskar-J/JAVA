import java.util.*;
public class killJoseph {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        System.out.println("Enter k:");
        int k=sc.nextInt();

        System.out.println("Index of Joseph :"+ saveJoseph(n,k));
    }
    public static int saveJoseph(int n,int k){
        if(n==1)
        return 0;
        int x=saveJoseph(n-1, k);
        int y=(x+k)%n;
        return y;
    }

}

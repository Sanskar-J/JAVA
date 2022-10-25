import java.util.*;
class Res{
    static String max = "";
}
public class maxAtKSwaps {
    
    public static void main(String[] args) {
        String s="254";
        Res r=new Res();
        r.max=s;
        KSwaps(s.toCharArray(), 2, r);
        System.out.println(r.max);
    }
    public static void KSwaps(char[]s,int k,Res r){
        if(k==0) return;
        int n=s.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(s[i]<s[j]){
                    char temp=s[i];
                    s[i]=s[j];
                    s[j]=temp;

                    String st=new String(s);
                    if(r.max.compareTo(st)<0)
                    r.max=st;

                    KSwaps(s, k-1, r);

                    temp=s[i];
                    s[i]=s[j];
                    s[j]=temp;
                }
            }
        }
    }
}

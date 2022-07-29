import java.util.*;
public class permOfString {
    public List<String> find_permutation(String str) {
        // Code here
        List<String>res=new ArrayList<>();
        int n=str.length();
        int f=fact(n);
        String s="";
        for(int i=0;i<f;i++){
            StringBuilder sb=new StringBuilder(str);
            int temp=i;
            s="";
            for( int div=n;div>=1;div--){
                int q=temp/div;
                int r=temp%div;
                s+=sb.charAt(r);
                sb.deleteCharAt(r);
                temp=q;
            }
            res.add(s);
        }
        
        return res;
        
    }
    public int fact(int n){
        int res=1;
        for(int i=2;i<=n;i++)
        res=res*i;
        
        return res;
    }
}

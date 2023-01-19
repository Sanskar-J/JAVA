import java.util.HashMap;

import org.xml.sax.HandlerBase;

public class scrambledString {
    //gonna do memoization also in the same code only
    static HashMap<String,Boolean> hm=new HashMap<>();
    public static void main(String[] args) {
        String a="great";
        String b="eatgr";
        // a = "phqtrnilf";
        // b = "ilthnqrpf";
        System.out.println(isScrambled(a, b));
    }
    public static boolean isScrambled(String a,String b){
        hm.clear();
        if(a.length()!=b.length())return false;
        if(a.isEmpty()&&b.isEmpty())return true;
        return solve(a,b);
    }
    public static boolean solve(String a,String b){
        if(a.compareTo(b)==0)return true;
        if(a.length()<=1)return false;
        String check=a+" "+b;
        if(hm.containsKey(check))return hm.get(check);//first check line of memoization
        int n=a.length();
        boolean flag=false;
        for(int i=1;i<n;i++){
            if(
                (solve(a.substring(0, i),b.substring(n-i,n))
                &&
                solve(a.substring(i, n),b.substring(0,n-i)))
                ||
                (solve(a.substring(0, i),b.substring(0,i))
                &&
                solve(a.substring(i, n),b.substring(i,n)))
                ){
                    flag=true;
                    break;
                }
        }
        //memoization
        hm.put(check,flag);
        //
        return flag;
    }

}

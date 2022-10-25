import java.util.*;
public class grayCode {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(makeGrayCode(n));
    }

    public static ArrayList<String> makeGrayCode(int n){
        if(n==1){
            ArrayList<String> baseCase=new ArrayList<>();
            baseCase.add("0");
            baseCase.add("1");
            return baseCase;
        }
        ArrayList<String>rec=makeGrayCode(n-1);
        ArrayList<String> more=new ArrayList<>();
        for(String s:rec)
        more.add("0"+s);
        for(String s:rec)
        more.add("1"+s);
        return more;
    }
}

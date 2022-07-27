import java.util.*;
public class getSSequence {
    public static void main(String ars[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter sequenc:");
        String str=sc.next();

        ArrayList <String> al=new ArrayList<>();
        al=getSub(str);
        for(String s :al)
        System.out.print(s+"  ");
    }
    public static ArrayList<String> getSub(String str){
        if(str.length()==0){
            ArrayList<String> bres=new ArrayList<>();
            bres.add("");
            return bres;
        }
        char ch=str.charAt(0);
        String left=str.substring(1);
        ArrayList<String> res= getSub(left);
        ArrayList<String> mRes=new ArrayList<>();
        for(String s:res){
            mRes.add(""+s);
            mRes.add(ch+s);
        }
        return mRes;
    }
}

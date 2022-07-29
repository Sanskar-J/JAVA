import java.util.*;
public class StringCompression {
    public static void main(String ar[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string : ");
        String s=sc.next();
        System.out.println("Compression 1: " + compress(s));
        System.out.println("Compression 2: " + compress2(s));
    }
    public static String compress(String s){
        StringBuilder str=new StringBuilder(""+s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)!=s.charAt(i-1)){
                str.append(s.charAt(i));
            }
        }
       
        return str.toString();
    }
    public static String compress2(String s){
        StringBuilder str=new StringBuilder(""+s.charAt(0));
        int help=0;
        for(int i=1;i<s.length();i++){
            help++;
            if(s.charAt(i)!=s.charAt(i-1)){
                str.append(help);
                str.append(s.charAt(i));
                
                help=0;
            }
            
        }
        str.append(help+1);
        return str.toString();
    }
}

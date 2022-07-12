import java.io.*;

import javax.lang.model.util.ElementScanner6;
public class first {
    // int a,b;
    // first(){
    //     this.a=12;
    //     this.b=25;
    // }
    // first(int a,int b){
    //     this.a=a;
    //     this.b=b;
    // }
    public static void main(String args[]){
        // int c=0;
        // while(c!= args.length){
        //     System.out.print( args[c] +" ");
        //     // System.out.println("Length is " + args[c].length());
        //     c++;
        // }
        int a=Integer.parseInt(args[0]);
        int b=Integer.parseInt(args[2]);
        if(args[1].equals("+"))
        System.out.println("   "+(a+b));
        if(args[1].equals("-"))
        System.out.println("   "+(a-b));
        if(args[1].equals("*"))
        System.out.println("   "+(a*b));
        if(args[1].equals("/"))
        System.out.println("   "+(a/b));

        double d=5.4532;
        System.out.print(d);
        
        
    }

}

import java.util.*;
class lexNum{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n");
        int n=sc.nextInt();
        for(int i=1;i<10;i++){
            printLexNum(i, n);
        }
    }
    public static void printLexNum(int i,int n){
        if(i>n)
        return;
        System.out.println(i);
        for(int j=0;j<10;j++)
            printLexNum(i*10+j, n);
        
    }
}
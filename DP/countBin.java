import java.util.*;
class countBin{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n: ");
        int n=sc.nextInt();
        int oz=1;
        int oo=1;
        for(int i=2;i<=n;i++){
            int nz=oo;
            int no=oz+oo;

            oz=nz;
            oo=no;
        }

        System.out.println((oz+oo));

    }
}
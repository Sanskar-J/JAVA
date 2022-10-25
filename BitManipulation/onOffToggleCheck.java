import java.util.*;
class onOffToggleCheck{
    public static void main(String[] args) {
        oOtC(35,3,5,4,2);
    }
    public static void oOtC(int n,int i,int j,int k,int m){
        int mask1=1;
        mask1=(mask1<<i);

        System.out.println((n|mask1));

        int mask2=1;
        mask2=(mask2<<j);
        mask2=(~mask2);

        System.out.println((n&mask2));

        int mask3=1;
        mask3=(mask3<<k);

        System.out.println((n^mask3));

        int mask4=(1<<m);

        System.out.println((n&mask4)==0?false:true);

    }
}
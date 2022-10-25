public class josephusProblem {
    public static void main(String[] args) {
        josephusFor2(8);
    }
    public static int powerOf2(int n){
        int i=1;
        while(i*2<=n)
        i=i*2;
        return i;
    }
    public static void josephusFor2(int n){
        int hp=powerOf2(n);
        int l=n-hp;
        System.out.println("No. who lived: "+(2*l+1));
    }
}

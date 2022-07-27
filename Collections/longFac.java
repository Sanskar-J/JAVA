import java.util.*;

class longFac {
    static ArrayList<Integer> r = new ArrayList<>();

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n ");
        int n = sc.nextInt();
        ArrayList<Integer> res = new ArrayList<>();
        r.add(1);
        res = fac(n);
        for (int a : res)
            System.out.print(a+" ");
    }

    public static ArrayList<Integer> fac(int n) {
        if (n == 1)
            return r;
        int x = 2;
        int ans = 0, carry = 0;
        while (x <= n) {
            for (int i = r.size() - 1; i >= 0; ) {
                ans = r.get(i) * x;
                System.out.println(ans);
                if (ans < 10) {
                    r.set(i, ans);
                } else {
                    r.set(i, ans % 10);
                    carry = ans / 10;
                    r.add(carry);
                    i--;
                }
               
            }
            x++;
            Collections.reverse(r);
            
            
        }
        return r;
    }
}
